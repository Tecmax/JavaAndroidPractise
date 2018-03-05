package com.tecmax.testaksh.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmax.testaksh.R;
import com.tecmax.testaksh.widg.AmazonActivity;
import com.tecmax.testaksh.widg.SeekbarActivity;

public class WidgetActivity extends AppCompatActivity implements View.OnClickListener{
    TextView first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        first = findViewById(R.id.abs);
        second = findViewById(R.id.absx);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
    }


    public void goToClock(View view) {
        switch (view.getId()) {
            case R.id.ccclock:
                startActivity(new Intent(this, TestActivity.class));
                break;
            case R.id.fb:
                startActivity(new Intent(this, SeekbarActivity.class));
                break;
            case R.id.rc:
                Intent intent =new Intent(this, AmazonActivity.class);
                intent.putExtra("myName","Harsha");
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_log, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aman:
                Intent intent =new Intent(this, ChromeActivity.class);
                intent.putExtra("webDetails","https://www.facebook.com/");
                startActivity(intent);
                break;
            case R.id.vamsi:
                Intent intent1 =new Intent(this, ChromeActivity.class);
                intent1.putExtra("webDetails","http://www.cricbuzz.com/");
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.abs:
                PopupMenu cf = new PopupMenu(WidgetActivity.this, second);
                cf.getMenuInflater().inflate(R.menu.menu_log,cf.getMenu());
                cf.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.aman:
                                Toast.makeText(WidgetActivity.this,
                                        "Hecds", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                cf.show();
                break;
            case R.id.absx:
                Toast.makeText(this, "Hecdsdddd", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
