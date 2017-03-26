package com.tayal.serverphp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ename,eemail,epassword,emobilenumber;
    Button btn,btn1;
    String name,email,password,mobilenumber ;
        String msg="",text;
    String line ="";
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        ename = (EditText) findViewById(R.id.editText1);
        eemail = (EditText) findViewById(R.id.editText3);
        emobilenumber = (EditText) findViewById(R.id.editText5);
        epassword = (EditText) findViewById(R.id.editText4);

        btn = (Button) findViewById(R.id.button1);
        btn1 = (Button) findViewById(R.id.button2);

        awesomeValidation.addValidation(this, R.id.editText1, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editText3, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editText4, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.editText5, "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", R.string.passworderror);

        btn.setOnClickListener(this);
    }
    private void submitForm()
    {
        if (awesomeValidation.validate())
        {
            Toast.makeText(this,"validation successfull",Toast.LENGTH_LONG).show();

        }

    }
    public void  onClick(View view ) {

        if (view == btn) {
            submitForm();


            btn.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    name = ename.getText().toString().trim();
                    email = eemail.getText().toString().trim();
                    mobilenumber = emobilenumber.getText().toString().trim();
                    password = epassword.getText().toString().trim();

                    new RecordSubmit().execute();


                }


                class RecordSubmit extends AsyncTask<Void, Void, Void> {
                    ProgressDialog pd;

                    @Override
                    protected void onPreExecute() {
                        // TODO Auto-generated method stub

                        super.onPreExecute();

                        pd = new ProgressDialog(MainActivity.this);
                        pd.show();
                    }

                    @Override
                    protected Void doInBackground(Void... params) {
                        // TODO Auto-generated method stub
                        getData();
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        // TODO Auto-generated method stub
                        super.onPostExecute(result);
                        pd.dismiss();
                        Toast.makeText(MainActivity.this, "data submitted", Toast.LENGTH_LONG).show();
                    }
                }

                public void getData() {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://10.0.2.2:81/insert/first.php");
                    JSONObject json = new JSONObject();

                    try {
                        // JSON data:
                        json.put("name", name);
                        json.put("email", email);
                        json.put("mobilenumber", mobilenumber);
                        json.put("password", password);

                        JSONArray postjson = new JSONArray();
                        postjson.put(json);

                        // Post the data:
                        httppost.setHeader("json", json.toString());
                        httppost.getParams().setParameter("jsonpost", postjson);

                        // Execute HTTP Post Request
                        System.out.print(json);
                        HttpResponse response = httpclient.execute(httppost);

                        // for JSON:
                        if (response != null) {
                            InputStream is = response.getEntity().getContent();

                            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                            StringBuilder sb = new StringBuilder();

                            String line = null;
                            try {
                                while ((line = reader.readLine()) != null) {
                                    sb.append(line + "\n");
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    is.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            text = sb.toString();
                        }

                        System.out.println(text);

                    } catch (Exception e) {
                        // TODO Auto-generated catch
                        System.out.println(e);
                    }
                }


            });
        }
    }
}