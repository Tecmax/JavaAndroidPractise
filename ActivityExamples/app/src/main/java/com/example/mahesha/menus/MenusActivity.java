package com.example.mahesha.menus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class MenusActivity extends AppCompatActivity {
    Button popupmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        popupmenu =  (Button) findViewById(R.id.bt_popup);
        popupmenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MenusActivity.this, popupmenu);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_login, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        Toast.makeText(MenusActivity.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return selectDate(item);
//                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        new MenuInflater(getApplication()).inflate(R.menu.menu_login, menu);
        MenuItem item = menu.findItem(R.id.item2);
        item.setVisible(false);
//        getMenuInflater().inflate(R.menu.menu_login, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.call:
                Toast.makeText(getApplicationContext(), "Call Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
        return selectDate(item);
    }
    boolean selectDate(MenuItem item){
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.call:
                Toast.makeText(getApplicationContext(), "Call Selected", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}
