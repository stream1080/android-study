package com.example.myapplication.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MyBindActivity extends AppCompatActivity implements View.OnClickListener {
    private ServiceConnection conn;
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
                conn = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyBindService.MyBinder myBinder = (MyBindService.MyBinder) service;
                        myBinder.playMusic("dasong.mp3");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                };
                bindService(intent,conn,BIND_AUTO_CREATE);
                break;

            case R.id.btn_unbind:
                unbindService(conn);
                break;

        }
    }
}