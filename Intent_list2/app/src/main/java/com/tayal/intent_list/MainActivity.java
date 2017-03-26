package com.tayal.intent_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // Array of strings...
    ListView listView;
    String[] mobileArray = {"Leonardo Dicaprio",
            "Robert Downey Jr.",
            "Johnny Depp",
            "Brad Pitt",
            "Tom Cruise",
            "Tom Hanks",
            "Will Smith",
            "Christian Bale",
            "Matt Damon",
            "Bradley Cooper",
            "George Clooney",
            "Robert De Niro",
            "Hugh Jackman",
            "Russell Crowe",
            "Dwayne Johnson",
            "Morgan Freeman",
            "Daniel Day-Lewis",
            "Ben Affleck",
            "Adam Sandler",
            "Vin Diesel",
            "Chris Hemsworth",
            "Jackie Chan",
            "Liam Neeson",
            "Jack Nicholsan",
            "Kevin Spacey",
            "Robert Downey Sr.",
            "Harrison Ford",
            "Sean Connery",
            "Samuel L.Jackson",
            "Sean Penn",
            "Zac Efron",
            "Ryan Gosling",
            "Channing Tatum",
            "Mathew McConaughey",
            "Marlon Brando",
            "Mel Gibson",
            "Sylvester Stallone",
            "Arnold Schwarzenegger",
            "Michael Caine",
            "Joaquin Phoenix",
            "Tom Hardy",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mobile_list);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), List.class);
                intent.putExtra("k", position);
                startActivity(intent);


            }
        });
    }
}
