package com.example.myapplication.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_create_db,btn_update_db,btn_delete_db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        bindView();
        setListeners();
    }

    private void setListeners() {
        btn_create_db.setOnClickListener(this);
        btn_update_db.setOnClickListener(this);
        btn_delete_db.setOnClickListener(this);
    }

    private void bindView() {
        btn_create_db = findViewById(R.id.btn_create_db);
        btn_update_db = findViewById(R.id.btn_update_db);
        btn_delete_db = findViewById(R.id.btn_delete_db);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_create_db:

                break;
            case R.id.btn_update_db:

                break;
            case R.id.btn_delete_db:

                break;
        }
    }
}