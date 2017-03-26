package com.example.lirisha.customizelistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lirisha on 27-07-2016.
 */
public class CustomList extends ArrayAdapter<String> {

    private String[] names;
    private String[] desc;
    private Integer[] imageid;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] desc, Integer[] imageid) {
        super(context, R.layout.list_layout, names);
        this.context = context;
        this.names = names;
        this.desc = desc;
        this.imageid = imageid;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  inflater = context.getLayoutInflater();
        View v= inflater.inflate(R.layout.list_layout,null,true);
        TextView textView =(TextView) v.findViewById(R.id.textView);
        TextView textView2 =(TextView) v.findViewById(R.id.textView2);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);
        textView.setText(names[position]);
        textView2.setText(desc[position]);
        img.setImageResource(imageid[position]);

          return v;


    }
}


