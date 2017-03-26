package com.example.lirisha.sharedpreference1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by lirisha on 07-08-2016.
 */
public class SecondActivity extends MainActivity {

    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "welcome ketan ",
                        Toast.LENGTH_LONG).show();

            }
        });


    }
}