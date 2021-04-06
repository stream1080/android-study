package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

public class CheckBoxActivity3 extends AppCompatActivity {
    private CheckBox ck_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box3);

        ck_2 = findViewById(R.id.ck_1);

    }
}