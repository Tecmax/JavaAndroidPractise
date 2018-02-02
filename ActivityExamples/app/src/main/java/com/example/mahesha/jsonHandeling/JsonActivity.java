package com.example.mahesha.jsonHandeling;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.jsonHandeling.entity.Course;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String js = loadJSONFromAsset(this);
        Gson g = new Gson();
        Course p = g.fromJson(js, Course.class);
        Course.CourseCategory[] courseCategories = p.getCategory();
        for (int i = 0; i < courseCategories.length; i++) {
            Toast.makeText(this, "" + courseCategories[i].getCourseDetail() + "\n"
                    + courseCategories[i].getCourseName(), Toast.LENGTH_SHORT).show();
        }

        Course course = new Course();

        List<Course.CourseCategory> courseCategoryList = new ArrayList<>();
        String[] courseName = {"TB", "AD", "IOS", "sssss"};
        String[] courseDetails = {"dsad", "sdas", "sdas", "ghdfd"};
        for (int i = 0; i < courseDetails.length; i++) {
            Course.CourseCategory courseCategory = course.new CourseCategory();
            courseCategory.setCourseDetail(courseDetails[i]);
            courseCategory.setCourseName(courseName[i]);
            courseCategoryList.add(courseCategory);
        }
        Course.CourseCategory names[] = courseCategoryList.toArray
                (new Course.CourseCategory[courseCategoryList.size()]);
        course.setCategory(names);
        Gson gson = new Gson();
        String json = gson.toJson(course);
        System.out.println(json);
        Log.e("Converted JSon", json);

    }


    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("courses.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
