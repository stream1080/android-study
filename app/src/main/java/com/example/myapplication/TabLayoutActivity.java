package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.widge.Flower;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabs;
    private ViewPager mVp;
    private List<Flower> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mTabs = findViewById(R.id.tab_id);
        mVp = findViewById(R.id.vp);

        initDate();
//        seTabView();
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),0,mList);
        mVp.setAdapter(myPagerAdapter);
        mTabs.setupWithViewPager(mVp);

        seTabView();
    }

    private void initDate() {
        mList = new ArrayList<Flower>();
        mList.add(new Flower(R.mipmap.maotai,"茅台"));
        mList.add(new Flower(R.mipmap.wly,"五粮"));
        mList.add(new Flower(R.mipmap.lzlj,"泸窖"));
        mList.add(new Flower(R.mipmap.jgj,"酒鬼"));
    }

    private void seTabView() {
        for (int i = 0; i < mList.size(); i++) {
            TabLayout.Tab tab = mTabs.getTabAt(i);
            tab.setCustomView(R.layout.tab_item);
            View view = tab.getCustomView();
            ImageView imageView = view.findViewById(R.id.tab_item_iv);
            TextView textView = view.findViewById(R.id.tab_item_tv);
            imageView.setImageResource(mList.get(i).getImageId());
            textView.setText(mList.get(i).getName());
        }
    }
}