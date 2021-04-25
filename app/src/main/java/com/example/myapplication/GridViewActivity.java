package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    private GridView mGv;
    private List<PhotoGrid> mPhotoGridList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mGv = findViewById(R.id.gv);
        initData();
        //通过构造函数，传参Activity
        MyGridAdapter myGridAdapter = new MyGridAdapter(GridViewActivity.this ,mPhotoGridList);
        mGv.setAdapter(myGridAdapter);

//        mGv.setOnItemClickListener(); 设置点击事件

    }

    private void initData() {
        mPhotoGridList = new ArrayList<PhotoGrid>();
        mPhotoGridList.add(new PhotoGrid(R.mipmap.maotai,"茅台"));

    }
}