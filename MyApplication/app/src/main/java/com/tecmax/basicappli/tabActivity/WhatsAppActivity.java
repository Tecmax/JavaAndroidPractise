package com.tecmax.basicappli.tabActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tecmax.basicappli.R;
import com.tecmax.basicappli.fragment.BlankFragment;
import com.tecmax.basicappli.fragment.InterFragment;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class WhatsAppActivity extends AppCompatActivity implements BlankFragment.onfragmentChange, InterFragment.OnFragmentInteractionListener {
    TabLayout layout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layout = findViewById(R.id.msgTabs);
        viewPager = findViewById(R.id.messageFragment);
        layout.setupWithViewPager(viewPager);
        ViewAdapter viewAdapter = new ViewAdapter(getSupportFragmentManager());
        viewAdapter.addDetails(new BlankFragment(), "Hello");
        viewAdapter.addDetails(new InterFragment(), "Harsha");
        viewAdapter.addDetails(new BlankFragment(), "Santosh");
        viewPager.setAdapter(viewAdapter);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void sendFragment(Fragment fragment, String tag) {

    }

    @Override
    public void onFragmentInteraction(String name, Uri uri) {

    }

    class ViewAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList;
        List<String> titleList;

        public ViewAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<>();
            titleList = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        void addDetails(Fragment fragment, String title) {
            fragmentList.add(fragment);
            titleList.add(title);
        }
    }

}
