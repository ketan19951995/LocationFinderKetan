package com.example.coustomizelistview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CoustomListAdapter1 extends ArrayAdapter<String>{
	Context mainActivity; int row;
	String[] arr; int[] imgarr;
    MainActivity ob = new MainActivity();
	public CoustomListAdapter1(Context mainActivity, int row,
			String[] arr, int[] imgarr) {
		// TODO Auto-generated constructor stub
		super(mainActivity, row, arr);
		
		this.mainActivity = mainActivity;
		this.row  =row;
		this.arr= arr;
		this.imgarr = imgarr;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater lif = (LayoutInflater)
		mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		convertView  = lif.inflate(row, null);
		ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
		TextView tv = (TextView)convertView.findViewById(R.id.textView1);
		Button btn = (Button)convertView.findViewById(R.id.button1);
		iv.setImageResource(imgarr[position]);
		tv.setText(arr[position]);		
		btn.setText(arr[position]);
		btn.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
                Toast.makeText(mainActivity, arr[position], Toast.LENGTH_LONG).show();
//                Intent i = new Intent();
//                i.setClass(getContext(),Main2Activity.class );
//                i.putExtra("ketan",imgarr[position]);
                ob.startNewIntent(1);
            }
		});
		return convertView;

	}

}
