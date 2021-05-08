package com.example.myapplication.Handle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import com.example.myapplication.R;

public class HandleActivity extends AppCompatActivity {

    private Button btn_handle;
    private TextView tv_handle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
        btn_handle = findViewById(R.id.btn_handle);
        tv_handle = findViewById(R.id.tv_handle);

        Handler handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    tv_handle.setText(msg.obj.toString());
                }
            }
        };



        btn_handle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = 1;
                        msg.obj = "new message";
                        handler.sendMessage(msg);
                    }
                }).start();
            }
        });
    }
}