package com.example.lirisha.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn;

    public static final String MYPREFERENCES="MyPrefs";

    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        btn=(Button)findViewById(R.id.button);
        sharedpreferences =getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=ed1.getText().toString();
                String ph=ed2.getText().toString();
                String e=ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();


                editor.putString(Name,n);
                editor.putString(Phone,ph);
                editor.putString(Email,e);

                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setClass(MainActivity.this ,SecondActivity.class);
                startActivity(i);


                
            }
        });
    }
    }

