package com.example.lirisha.sharedpreference1;



import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lirisha.sharedpreference1.MainActivity;

public class MainActivity extends Activity {
    SharedPreferences spref;
    String pass="";
    EditText edt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spref = (SharedPreferences)
                PreferenceManager.getDefaultSharedPreferences(this);
        pass = spref.getString("p","");
        edt = (EditText)findViewById(R.id.editText1);
        btn =(Button)findViewById(R.id.button1);


        if(pass.equals(""))
        {
            btn.setText("Register your self");
        }
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String msg = edt.getText().toString().trim();
                if(!msg.equals(""))
                {
                    if(pass.equals(""))
                    {
                        SharedPreferences.Editor spe = spref.edit();

                        spe.putString("p", msg);
                        spe.commit();
                        Toast.makeText(MainActivity.this, "Password set",
                                Toast.LENGTH_LONG).show();
                        edt.setText("");
                        btn.setText("LOGIN");
                    }
                    else
                    {
                        if(msg.equals(pass))
                        {
                            Toast.makeText(MainActivity.this, "Login success",
                                    Toast.LENGTH_LONG).show();
                            Intent i = new Intent();
                                    i.setClass(MainActivity.this ,SecondActivity.class);
                            startActivity(i);

                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Login denied",
                                    Toast.LENGTH_SHORT).show();
                        }}}
                else
                {
                    Toast.makeText(MainActivity.this, "must enter password",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }



}
