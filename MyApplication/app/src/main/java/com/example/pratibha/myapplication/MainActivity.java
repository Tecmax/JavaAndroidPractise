package com.example.pratibha.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ListView leftList;
    private ListView rightList;
    private String[] leftListStrings;
    private String[] rightListStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        leftList = (ListView) findViewById(R.id.left_list);
        rightList = (ListView) findViewById(R.id.right_list);


        leftListStrings = getResources().getStringArray(R.array.left);

        leftList.setAdapter(new ArrayAdapter<String>(this,R.layout.nav_header_main,R.id.item_title,leftListStrings));

        rightListStrings = getResources().getStringArray(R.array.left);

        List<String> stringList = Arrays.asList(rightListStrings);

        rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
        rightList.setVisibility(View.VISIBLE);


        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {


                arg1.setBackgroundColor(Color.WHITE);

                if(arg2 == 0){

                    rightListStrings = getResources().getStringArray(R.array.rightOne);

                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);
                    overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);

                }
                if(arg2 == 1){

                    rightListStrings = getResources().getStringArray(R.array.rightTwo);
                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);
                }
                if(arg2 == 2){

                    rightListStrings = getResources().getStringArray(R.array.rightThree);
                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);

                }

                if(arg2 == 2){

                    rightListStrings = getResources().getStringArray(R.array.rightFour);
                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);

                }
            }

        });

        rightList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {


                arg1.setBackgroundColor(Color.WHITE);

                if(arg2 == 0){

                    rightListStrings = getResources().getStringArray(R.array.rightOne);

                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);

                }
                if(arg2 == 1){

                    rightListStrings = getResources().getStringArray(R.array.rightTwo);
                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);
                }
                if(arg2 == 2){

                    rightListStrings = getResources().getStringArray(R.array.rightThree);
                    List<String> stringList = Arrays.asList(rightListStrings);

                    rightList.setAdapter(new MyCustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, stringList));
                    rightList.setVisibility(View.VISIBLE);

                }
            }

        });



        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDrawerSlide(View arg0, float arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDrawerOpened(View arg0) {

                // TODO Auto-generated method stub

                drawer.openDrawer(GravityCompat.START);  // OPEN DRAWER


            }

            @Override
            public void onDrawerClosed(View arg0) {
                // TODO Auto-generated method stub

            }
        });




    }


    // My adapter class



    class MyCustomAdapter extends ArrayAdapter<String>{

        List<String> myList = null;
        public MyCustomAdapter(Context context, int resource,List<String> objects) {
            super(context, resource,  objects);
            myList = objects;
        }
        public List<String> getMyList() {
            return myList;
        }
        public void setMyList(List<String> myList) {
            this.myList = myList;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id)
        {
        case android.R.id.home:
        drawer.openDrawer(GravityCompat.START);
        return true;


            case R.id.action_search: // can be used to perform search
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // turn on the Navigation Drawer image;

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }
    }
}