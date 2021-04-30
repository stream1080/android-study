package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToActivity extends AppCompatActivity {

    private Button btn_to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);

        btn_to = findViewById(R.id.btn_to);

        btn_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //接收结果
                Intent intent = new Intent();
                intent.putExtra("result","Come Back");
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });


        //修改标题
        setTitle(getIntent().getStringExtra("Transfer"));

        //接受数据
        Bundle bundle = getIntent().getExtras();
        bundle.getString("name");
        bundle.getInt("age");
        setTitle(bundle.getString("name")+bundle.getInt("age"));
    }
}