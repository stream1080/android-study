package com.example.myapplication.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name,et_password;
    private Button btn_save,btn_read;
    private TextView tv_show;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        bindView();
        setListeners();
        sharedPreferences = getSharedPreferences("cloud",MODE_PRIVATE);//文件名cloud，直接覆盖

    }

    private void setListeners() {
        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    private void bindView() {
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        btn_save = findViewById(R.id.btn_save);
        btn_read = findViewById(R.id.btn_read);
        tv_show = findViewById(R.id.tv_show);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save:
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",et_name.getText().toString());
                editor.putString("password",et_password.getText().toString());
                editor.apply();//写入数据
                break;

            case R.id.btn_read:
                String name = sharedPreferences.getString("name","");
                String password = sharedPreferences.getString("password","");
                tv_show.setText(name+":"+password);
               // tv_show.setText(sharedPreferences.getString("name","")+":"+sharedPreferences.getString("password",""));
                break;
        }
    }
}