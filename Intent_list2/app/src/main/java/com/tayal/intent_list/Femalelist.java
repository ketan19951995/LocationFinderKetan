package com.tayal.intent_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by lirisha on 09-01-2017.
 */



public class Femalelist extends AppCompatActivity {
    // Array of strings...
    ListView listView1;


    String[] mobileArray1 = {
            " Angelina_Jolie",
            "Scarlett_Johansson",
            "Natalie_Portman",
            " Jennifer_Aniston",
            "Charlize_Theron",
            "Jennifer_Lawrence",
            "Mila_Kunis",
            "Emma_Stone",
            "Jessica Alba",
            "Julia Roberts",
            "Cameron Diaz",
            "Sandra Bullock",
            "Kristen Stewart",
            "Megan Fox",
            "Meryl Streep",
            "Kate Winslet",
            "Marion Cotillard",
            "Keira Knightley",
            "Anne Hathaway",
            "Amy Adams",
            "Nicole Kidman",
            "Emma Watson",
            "Audrey Hepburn",
            "Marilyn Monroe",
            "Penélope Cruz",
            "Cate Blanchett",
            "Olivia Wilde",
            "Reese Witherspoon",
            "Halle Berry",
            "Margot Robbie",
            "Gwyneth Paltrow",
            "Melissa McCarthy",
            "Grace Kelly",
            "Katharine Hepburn",
            "Joan Crawford",
            "Elizabeth Taylor",
            "Amanda Seyfried",
            "Bette Davis",
            "Drew Barrymore",
            "Monica Bellucci",
            "Vanessa Johansson",
            "Kirsten Dunst",
            "Ingrid Bergman",
            "Rachel McAdams",
            "Salma Hayek",
            "Blake Lively",
            "Rita Hayworth",
            "Michelle Pfeiffer",
            "Julianne Moore",
            "Ava Gardner",
            "Jessica Biel"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.mobile_list);
        final ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray1);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplicationContext(), List1fem.class);
                intent.putExtra("k", position);
                startActivity(intent);


            }
        });

    }
}