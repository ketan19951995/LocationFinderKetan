package com.example.locationfinder;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends Activity {
String APIKEY,reference,lat,lng;
TextView name,vicinity,address,phone;
RatingBar rating;
Button btn;
PlaceDetail placeinfor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		name = (TextView) findViewById(R.id.textView1);
		vicinity = (TextView) findViewById(R.id.textView2);
		address = (TextView) findViewById(R.id.textView4);
		phone = (TextView) findViewById(R.id.textView6);
		rating = (RatingBar)findViewById(R.id.ratingBar1);
		btn = (Button)findViewById(R.id.button1);
 		
		 APIKEY = getIntent().getExtras().getString("apikey");
		 reference = getIntent().getExtras().getString("ref");
		 lat = getIntent().getExtras().getString("lat");
		 lng = getIntent().getExtras().getString("lng");
						
		 
		new back().execute();
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String latitude = lat;
				String longitude = lng;
				String label = placeinfor.getname()+placeinfor.getvicinity();
				String uriBegin = "geo:" + latitude + "," + longitude;
				String query = latitude + "," + longitude + "(" + label + ")";
				String encodedQuery = Uri.encode(query);
				String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
				Uri uri = Uri.parse(uriString);
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
				startActivity(intent);
				
			}
		});
	}

	class back extends AsyncTask<Void, Void, Void>{
		
		ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(Detail.this);
			dialog.setMessage("please wait......");
			dialog.show();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			readXML_detail detail = new readXML_detail();
			
			
			placeinfor = detail.XMLread(reference, APIKEY);
			
			//
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			dialog.dismiss();
		
			name.setText(placeinfor.getname());
			vicinity.setText(placeinfor.getvicinity());
			address.setText(placeinfor.getaddress());
			if(placeinfor.getphone().equals("0")){
				phone.setText("Data Not available");
			}else{
				phone.setText(placeinfor.getphone());	
			}
			
			rating.setRating(new Float(placeinfor.getrating()));
			
			super.onPostExecute(result);
		}
		
		
		
	}

}
