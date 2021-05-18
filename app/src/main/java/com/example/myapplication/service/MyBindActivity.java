package com.example.myapplication.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MyBindActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind,btn_unbind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bind);


        bindView();
        setListeners();

    }

    private void setListeners() {
        btn_bind.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
    }

    private void bindView() {
        btn_bind = findViewById(R.id.btn_bind);
        btn_unbind = findViewById(R.id.btn_unbind);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:
                Intent intent = new Intent(MyBindActivity.this,MyBindService.class);
                intent.putExtra("start","MyStartService");//传递参数
                startService(intent);
                break;

            case R.id.btn_unbind:
                Intent intent1 = new Intent(MyBindActivity.this,MyBindService.class);
                intent1.putExtra("start","MyStartService");//传递参数
                stopService(intent1);
                break;
        }
    }
}