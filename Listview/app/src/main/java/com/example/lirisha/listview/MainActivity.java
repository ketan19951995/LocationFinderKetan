package com.example.lirisha.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String [] monthArray={"jan","feb","march","","may","june","july","","sep","","nov"};
    private String [] monthArrays={"jan","feb","march","","may","june","july","","sep","","nov"};
    private ListView lv;
    private ListView lv1;
    private ArrayAdapter adp;
    private ArrayAdapter Adp1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView)findViewById(R.id.listView);
        lv1=(ListView)findViewById(R.id.listView1);
        adp= new ArrayAdapter(this,android.R.layout.simple_list_item_1,monthArray);
        Adp1= new ArrayAdapter(this,android.R.layout.simple_list_item_1,monthArrays);
        lv.setAdapter(adp);
        lv1.setAdapter(Adp1);
    }
}
