package com.example.lirisha.navigationdrawer;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()

        {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
               // drawerLayout.closeDrawer(navigationView);

                switch (menuItem.getItemId())
                {
                    case R.id.inbox:
                       Toast.makeText(getApplicationContext(),"inbox selected ",Toast.LENGTH_LONG).show();
                        return true;

                    case R.id.starred:
                        Toast.makeText(getApplicationContext(), "starred selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.sent_mail:
                        Toast.makeText(getApplicationContext(), "send selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.drafts:
                        Toast.makeText(getApplicationContext(), "Drafts selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.allmail:
                        Toast.makeText(getApplicationContext(), "all mail selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.trash:
                        Toast.makeText(getApplicationContext(), "trash selected", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.spam:
                        Toast.makeText(getApplicationContext(), "spam selected", Toast.LENGTH_LONG).show();
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();
                        return true;


                }


            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.nvView);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };


        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();


    }
}