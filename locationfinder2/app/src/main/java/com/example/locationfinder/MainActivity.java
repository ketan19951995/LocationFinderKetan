package com.example.locationfinder;


import java.util.ArrayList;




import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
Button btn;
private ArrayList<UpdateItem> m_orders = null;
private OrderAdapter m_adapter;
private Runnable viewOrders;
ProgressDialog progress;
private String location,key,radius;
private String APIKEY = "AIzaSyB_UQ8GT4PcrReyUwZyK5OtnSgm1ceKNjk";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		location = getIntent().getExtras().getString("location");
		key = getIntent().getExtras().getString("key");
		radius = 	getIntent().getExtras().getString("radius");
		
		m_orders = new ArrayList<UpdateItem>();
		
        this.m_adapter = new OrderAdapter(this, R.layout.row, m_orders,key);
        
        setListAdapter(this.m_adapter);
        progress = new ProgressDialog(this);
        progress.setMessage("Please wait.....");
        progress.show();
        
        viewOrders = new Runnable(){
            @Override
            public void run() {
            	
            	getOrders();
            	
    			progress.dismiss();
            }
        };
        
       
     	
        Thread thread =  new Thread(null, viewOrders, "MagentoBackground");
        thread.start();
        
		
	}
	
	 private void getOrders(){
         try{
        	 
             
        	 ReadXMLFile read = new ReadXMLFile();
          	m_orders = read.ReadXML("https://maps.googleapis.com/maps/api/place/nearbysearch/xml?location="+location+"&radius="+radius+"&keyword="+key+"&sensor=false&key="+APIKEY, "");
            
             
             
          
             Log.i("ARRAY", ""+ m_orders.size());
           } catch (Exception e) {
             Log.e("BACKGROUND_PROC", e.getMessage());
           }
           runOnUiThread(returnRes);
       }

	 private Runnable returnRes = new Runnable() {

	        @Override
	        public void run() {
	            if(m_orders != null && m_orders.size() > 0){
	                m_adapter.notifyDataSetChanged();
	                for(int i=0;i<m_orders.size();i++)
	                m_adapter.add(m_orders.get(i));
	            }
	            
	            m_adapter.notifyDataSetChanged();
	        }
	    };


	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		UpdateItem data = m_adapter.getItem(position);
		
		/*String latitude = data.getlat();
		String longitude = data.getlng();
		String label = data.getName()+data.getVicinity();
		String uriBegin = "geo:" + latitude + "," + longitude;
		String query = latitude + "," + longitude + "(" + label + ")";
		String encodedQuery = Uri.encode(query);
		String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
		Uri uri = Uri.parse(uriString);
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
		startActivity(intent);*/
		
		Intent place = new Intent(v.getContext(), Detail.class);
		place.putExtra("apikey", APIKEY);
		place.putExtra("ref", data.getreference());
		place.putExtra("lat", data.getlat());
		place.putExtra("lng", data.getlng());
		startActivity(place);
		
		super.onListItemClick(l, v, position, id);
	}
	
	
	

}
