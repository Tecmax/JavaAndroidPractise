package com.walmart.latest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.rvCont);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL,false);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        view.setLayoutManager(layoutManager);
        view.setHasFixedSize(true);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Santosh", "A", "V"));
        students.add(new Student("Mahesh", "b", "VI"));
        students.add(new Student("hasish", "e", "IV"));
        students.add(new Student("harish", "d", "VIII"));
        students.add(new Student("prakash", "c", "XII"));

        RvAdap rvAdap = new RvAdap(students);
        view.setAdapter(rvAdap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sec) {
            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
