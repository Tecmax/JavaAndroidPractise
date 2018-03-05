package com.tecmax.testaksh.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tecmax.testaksh.R;
import com.tecmax.testaksh.fragments.LoginFragment;
import com.tecmax.testaksh.fragments.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

public class WhatsTabActivity extends AppCompatActivity {
    TabLayout tab;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tab = findViewById(R.id.whatTab);
        vp = findViewById(R.id.pager);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tab.setupWithViewPager(vp);
        ViewWhatAdap viewWhatAdap = new ViewWhatAdap(getSupportFragmentManager());
        viewWhatAdap.addFragment(new WelcomeFragment(), "Welcome");
        viewWhatAdap.addFragment(new LoginFragment(), "Login");
        viewWhatAdap.addFragment(new LoginFragment(), "Login");
        viewWhatAdap.addFragment(new LoginFragment(), "Login");
        viewWhatAdap.addFragment(new LoginFragment(), "Login");
        viewWhatAdap.addFragment(new LoginFragment(), "Login");
        vp.setAdapter(viewWhatAdap);
    }

    class ViewWhatAdap extends FragmentPagerAdapter {
        public List<Fragment> fl;
        public List<String> ft;

        public ViewWhatAdap(FragmentManager fm) {
            super(fm);
            fl= new ArrayList<>();
            ft= new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return fl.get(position);
        }

        @Override
        public int getCount() {
            return fl.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return ft.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            fl.add(fragment);
            ft.add(title);
        }

    }

}
