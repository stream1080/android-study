package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private ListView mLv;
    private List<Photo> mPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData();
        mLv = findViewById(R.id.lv);
        //加载数据
        mLv.setAdapter(new MyListAdapter(ListViewActivity.this,mPhotoList));
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,mPhotoList.get(position).getTitle(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initData() {
        mPhotoList = new ArrayList<Photo>();
        mPhotoList.add(new Photo(R.drawable.hard,"空空1","空空如也1"));
        mPhotoList.add(new Photo(R.drawable.me_select,"空空2","空空如也2"));
        mPhotoList.add(new Photo(R.drawable.other,"空空3","空空如也3"));
        mPhotoList.add(new Photo(R.drawable.me_select,"空空4","空空如也4"));
        mPhotoList.add(new Photo(R.drawable.me_select,"空空5","空空如也5"));
    }
}