package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_button,btn_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_button = findViewById(R.id.btn_button);
        btn_edit =findViewById(R.id.btn_edit);

        OnClicker onClicker = new OnClicker();//初始监听器
        btn_button.setOnClickListener(onClicker);//btn_button注册监听器
        btn_edit.setOnClickListener(onClicker);//btn_edit注册监听器
    }

    class OnClicker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null; //初始化
            switch (v.getId()){
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edit:
                    intent = new Intent(MainActivity.this,TableActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}