package com.example.lirisha.externaldatabase;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;


import android.app.Activity;
import android.util.Log;

import android.widget.TextView;


public class MainActivity extends Activity {
    TextView tv;
    String record = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =(TextView)findViewById(R.id.textView);

        new Asy().execute();
    }

    class  Asy extends AsyncTask<Void,Void,Void>
    {


        @Override
        protected Void doInBackground(Void... params) {

            getData();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tv.setText(record);
        }
    }

    public  void getData()
    {

        String result ="";
        InputStream isr =null;

        //for getting data
        try {

             HttpClient httpclient = new DefaultHttpClient();
             HttpPost httppost = new HttpPost("http:/Newfolder/data.php");
             HttpResponse response = httpclient.execute(httppost);

            if (response != null)

            {
                System.out.print("connection created");

            }

            HttpEntity entity = response.getEntity();
            isr = entity.getContent();

        }

        catch (Exception e)
        {
            Log.i("error",e.toString());
            tv.setText("connection not created");



        }
//convert response to string

        try {

            InputStreamReader isre = new InputStreamReader(isr, "iso-8859-1");
            BufferedReader reader = new BufferedReader(isre, 8);
            StringBuilder sb = new StringBuilder();
            String line = "null";
            line = reader.readLine();
            while (!line.equals(null)) {
                sb.append(line + "\n");
                line = reader.readLine();
            }
            isr.close();
            result = sb.toString();
            System.out.print(sb);
            tv.setText(result);
        }
    catch(Exception e)
    {
        Log.e("log_tag", "Error converting result "+e.toString());


    }

        try {

            JSONArray jArray = new JSONArray(result);
            for (int i=0; i<jArray.length(); i++)
            {

                JSONObject jobj = jArray.getJSONObject(i);
                record = record+"\n" +i+" Name : "+jobj.getString("C_Name")+
                        " Fee: "+jobj.getString("C_Fee");


            }

            System.out.println(record);
        }
            catch(JSONException e)
        {
            Log.e("log_tag", "Error parsing data "+e.toString());
        }

    }


}

