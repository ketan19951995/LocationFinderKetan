package com.example.coustomizelistview;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
	String arr[]={"About"," Call ", " Carrer ", " course ", " Email "};
	Intent in;
	int imgarr[]={R.drawable.aboutus,R.drawable.call1,R.drawable.career,R.drawable.courses,R.drawable.email};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView)findViewById(R.id.listView1);
		CoustomListAdapter1 clp = new CoustomListAdapter1(MainActivity.this,R.layout.row,arr,imgarr);
		lv.setAdapter(clp);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startNewIntent(int id) {
		switch(id) {
			case 1:
				in = new Intent(getApplicationContext(), Main2Activity.class);
				startActivity(in);
				break;
		}
	}
}
