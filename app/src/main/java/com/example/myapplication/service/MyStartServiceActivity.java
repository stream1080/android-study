package com.example.myapplication.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MyStartServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start,btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_start_service);

        bindView();
        setListeners();

    }

    private void setListeners() {
        btn_start.setOnClickListener(this);
        btn_start.setOnClickListener(this);
    }

    private void bindView() {
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.btn_start:
               Intent intent = new Intent(MyStartServiceActivity.this,MyStartService.class);
               intent.putExtra("start","MyStartService");//传递参数
               startService(intent);
               break;

           case R.id.btn_stop:
               Intent intent1 = new Intent(MyStartServiceActivity.this,MyStartService.class);
               intent1.putExtra("start","MyStartService");//传递参数
               stopService(intent1);
               break;

       }
    }
}