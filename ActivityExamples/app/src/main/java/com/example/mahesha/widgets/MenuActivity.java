package com.example.mahesha.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.menus.ContextMenuActivity;
import com.example.mahesha.menus.MenusActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        Button contextMenu = (Button) findViewById(R.id.context_menu);
        Button optionsMenu = (Button) findViewById(R.id.options_menu);
        contextMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ContextMenuActivity.class));
            }
        });
        optionsMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MenusActivity.class));
            }
        });
    }
}
