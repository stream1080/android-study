package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SendStaticActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_static;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_static);

        btn_static = findViewById(R.id.btn_static);
        btn_static.setOnClickListener(this);
    }

    //用activity本身来监听
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_static:
                Intent intent = new Intent();
                intent.setAction("new Static Broadcast");
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
                break;
        }
    }
}