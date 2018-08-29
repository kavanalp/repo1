package com.example.kavan.behrouzkhani.activities;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.example.kavan.behrouzkhani.fragment.First;
import com.example.kavan.behrouzkhani.R;

import java.util.ArrayList;

public class Courses extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_instagram);

        initialize();
        setUpViewpager();
        setUpTabs();
    }

    private void setUpViewpager() {

        ViewpagerAdapter adapter = new ViewpagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new First(), "one");
        adapter.addFragment(new First(), "two");

        adapter.addFragment(new First(), "هدف");
        adapter.addFragment(new First(), "آفرینش");

        viewPager.setAdapter(adapter);

    }

    private void initialize() {
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.setupWithViewPager(viewPager );


    }

    private class ViewpagerAdapter extends FragmentPagerAdapter {

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public ViewpagerAdapter(FragmentManager fm) {
            super(fm);
        }


        public void addFragment(Fragment f, String s) {

            fragmentArrayList.add(f);
            stringArrayList.add(s);

        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringArrayList.get(position);
        }
    }

    private void setUpTabs() {
        TextView tabone = (TextView) LayoutInflater.from(this).inflate(R.layout.mytextview , null);

        TextView tabtwo = (TextView) LayoutInflater.from(this).inflate(R.layout.mytextview , null);

        TextView tabthree = (TextView) LayoutInflater.from(this).inflate(R.layout.mytextview , null);

        TextView tabfour= (TextView) LayoutInflater.from(this).inflate(R.layout.mytextview , null);
        tabone.setText("توحید");
        tabLayout.getTabAt(0).setCustomView(tabone);
        tabtwo.setText("ثروت");
        tabLayout.getTabAt(1).setCustomView(tabtwo);
        tabthree.setText("هدف");
        tabLayout.getTabAt(2).setCustomView(tabthree);
        tabfour.setText("آفرینش");
        tabLayout.getTabAt(3).setCustomView(tabfour);




    }
}
