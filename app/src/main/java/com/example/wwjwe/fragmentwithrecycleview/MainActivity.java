package com.example.wwjwe.fragmentwithrecycleview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout= findViewById(R.id.tlNav);
        viewPager= findViewById(R.id.vpMain);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment Here

        viewPagerAdapter.AddFragment(new FragmentCall(),"");
        viewPagerAdapter.AddFragment(new FragmentContact(),"");
        viewPagerAdapter.AddFragment(new FragmentFav(),"");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call_white_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts_white_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite_white_24dp);

        //Remove shadow from the action bar
        ActionBar actionBar =getSupportActionBar();
        actionBar.setElevation(0);
    }
}
