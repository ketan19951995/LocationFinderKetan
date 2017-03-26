package com.example.lirisha.myimagelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    int imgid[] = {R.drawable.css,R.drawable.ic_drawer,R.drawable.drawer_shadow,R.drawable.css,R.drawable.html,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gridView);
        ImageAdpater iadp = new ImageAdpater();
        gv.setAdapter(iadp);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {

                Intent i = new Intent();
                i.setClass(MainActivity.this, LargeImage.class);
                i.putExtra("key",imgid[pos]);
                startActivity(i);


            }
        });
    }


    class ImageAdpater extends BaseAdapter {
        @Override
        public int getCount() {
            return imgid.length;

        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg1)
        {

            return arg1;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView iv = new ImageView(MainActivity.this);
            iv.setImageResource(imgid[position]);
            iv.setLayoutParams(new GridView.LayoutParams(100, 100));
            iv.setPadding(20, 20, 20, 20);
            return iv;
        }

    }
}
