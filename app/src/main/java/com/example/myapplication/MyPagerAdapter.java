package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.widge.Flower;

import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private List<Flower> list;
    public MyPagerAdapter(@NonNull FragmentManager fm, int behavior, List<Flower> list) {
        super(fm, behavior);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new MyTabFragment();
        Bundle args = new Bundle();
        args.putParcelable("flower",list.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
