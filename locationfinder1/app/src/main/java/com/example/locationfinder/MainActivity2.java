package com.example.locationfinder;


import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnItemSelectedListener {

	LocationManager locationManager ;
	LocationListener locationListener;
	TextView txt;
	Location locations;
	CheckBox check;
	Button btn;
	Spinner spin;
	EditText edit;
	ArrayAdapter<String> adapter;
	String [] values = {"Set Radius","1 Km","2 Km","3 Km","4 Km","5 Km","6 Km","7 Km","8 Km","9 Km"};
	String [] radius = {"0","1000","2000","3000","4000","5000","6000","7000","8000","9000",};
	int radius_int=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		
		txt = (TextView)findViewById(R.id.textView2);
		txt.setVisibility(View.INVISIBLE);
		check = (CheckBox)findViewById(R.id.checkBox1);
		btn = (Button)findViewById(R.id.button1);
		edit = (EditText)findViewById(R.id.editText1);
		spin = (Spinner)findViewById(R.id.spinner1);
		
		 adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values); 
			spin.setAdapter(adapter);	
			
			spin.setOnItemSelectedListener(this);
			
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if(arg1){
					
					btn.setEnabled(false);
					
		              txt.setVisibility(View.VISIBLE);
		              
		              txt.setText("Please wait.....");
		              
					locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
				}else{
					Log.i("MO", "false");
					locationManager.removeUpdates(locationListener);
					btn.setEnabled(true);
					txt.setVisibility(View.INVISIBLE);
				}
				
			}
		});
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		
		
		
		
	       locationListener = new LocationListener() {
	            public void onLocationChanged(Location location) {
	            	
	              locations = location;
	              
	              txt.setText(String.valueOf(location.getLatitude())+","+String.valueOf(location.getLongitude()));
	              txt.setVisibility(View.VISIBLE);
	              btn.setEnabled(true);
	         Toast.makeText(MainActivity2.this,"New Location deteted"	,Toast.LENGTH_SHORT).show();
	            }

	            public void onStatusChanged(String provider, int status, Bundle extras) {
	            	
	            	
	            }

	            public void onProviderEnabled(String provider) {}

	            public void onProviderDisabled(String provider) {
	            	 Toast.makeText(MainActivity2.this,"GPS/Use Wireless network is not enabled"	,Toast.LENGTH_SHORT).show();
	            	
	            	
	            }
	          };
	
	          btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(radius_int!=0){
					if(check.isChecked()){
						Intent i = new Intent(v.getContext(), MainActivity.class);
						 
						i.putExtra("location", String.valueOf(locations.getLatitude())+","+String.valueOf(locations.getLongitude()));
						
						i.putExtra("key", edit.getText().toString());
						i.putExtra("radius", radius[radius_int]);
						startActivity(i);
					}else{
						Intent i = new Intent(v.getContext(), MainActivity.class);
						
						i.putExtra("location", "28.61135,77.226334");
						i.putExtra("key", edit.getText().toString());
						i.putExtra("radius", radius[radius_int]);
						startActivity(i);
					}
				}else{
					Toast.makeText(MainActivity2.this, "Please Select Valid Radius",Toast.LENGTH_SHORT).show();
				}
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
		return true;
	}

	@Override
	protected void onPause() {
		locationManager.removeUpdates(locationListener);
		super.onPause();
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		radius_int=arg2;
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	

}
