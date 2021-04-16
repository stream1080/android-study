package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressActivity extends AppCompatActivity {
    private Button btn_gundong,btn_shuiping;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        btn_gundong = findViewById(R.id.btn_gundong);
        btn_shuiping = findViewById(R.id.btn_shuiping);
        pb = findViewById(R.id.pb);

        pb.postDelayed(new Runnable() {
            @Override
            public void run() {
                pb.setVisibility(View.GONE);
            }
        },5000);


        btn_shuiping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinnerDialog();
            }
        });


        btn_gundong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horizontalDialog();
            }
        });



    }

        private void horizontalDialog() {
        ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(200);
        progressDialog.setProgress(0);
        progressDialog.setSecondaryProgress(20);
        progressDialog.show();

        //新建一个线程，实现进度对话框的进度条增加
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressDialog.getProgress()<progressDialog.getMax()){
                    progressDialog.incrementProgressBy(5);
                    progressDialog.incrementSecondaryProgressBy(5);
                    try {
                        //休息5000毫秒
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //关闭对话框
                progressDialog.dismiss();
            }
        }).start();

    }

    private void spinnerDialog() {
        ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
        progressDialog.setIcon(R.drawable.me_select);
        progressDialog.setTitle("天气预报");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("请耐心等待");
        progressDialog.show();

    }
}