package com.example.lirisha.myimagelist;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by lirisha on 28-07-2016.
 */
public class LargeImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b =getIntent().getExtras();
        int id =b.getInt("key");
        ImageView iv =(ImageView)findViewById(R.id.imageView);
        iv.setImageResource(id);
    }
}
