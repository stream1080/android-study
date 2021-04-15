package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {
    private Button btn_normal,btn_items,btn_single,btn_multi,btn_custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btn_normal = findViewById(R.id.btn_normal);
        btn_items = findViewById(R.id.btn_items);
        btn_single = findViewById(R.id.btn_single);
        btn_multi = findViewById(R.id.btn_multi);
        btn_custom = findViewById(R.id.btn_custom);

        OnCliker onCliker = new OnCliker();
        btn_normal.setOnClickListener(onCliker);
        btn_items.setOnClickListener(onCliker);
        btn_single.setOnClickListener(onCliker);
        btn_multi.setOnClickListener(onCliker);
        btn_custom.setOnClickListener(onCliker);
    }
    private class OnCliker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_normal:
                    normalDialog();
                    break;
                case R.id.btn_items:
                    itemsDialog();
                    break;
                case R.id.btn_single:
                    singleDialog();
                    break;
                case R.id.btn_multi:
                    multiDialog();
                    break;
                case R.id.btn_custom:
                    customDialog();
                    break;
            }
        }
    }

    private void customDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this,R.style.dialogStyle);
        View dialogView = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_custom,null);
        builder.setView(dialogView).show();
    }

    private void multiDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        String[] hobbies = {"画画","游戏","敲代码","考研"};
        boolean[] flags = {false,true,true,false};
        String temp = "";
        builder.setMultiChoiceItems(hobbies, flags, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                flags[which] = isChecked;

            }
        }).show();
        for (int i = 0; i <flags.length ; i++) {
            if(flags[i])
                temp += hobbies[i]+" ";
        }
    }

    private void singleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        String[] lesson = {"android","test","UI"};
        int checkItem = 0;
        builder.setIcon(R.mipmap.ic_launcher_round)
                .setTitle("单选提示")
                .setSingleChoiceItems(lesson, checkItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this,lesson[checkItem],Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    private void itemsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        String[] items={"android","ios","html","java","C#"};
        builder.setIcon(R.mipmap.ic_launcher_round)
                .setTitle("列表提示")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this,items[which],Toast.LENGTH_LONG).show();
                    }
                }).show();
    }

    private void normalDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("普通提示")
                .setMessage("今天的课听懂了吗")
                .setPositiveButton("懂了吗", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this,"positive:"+which,Toast.LENGTH_LONG).show();
                    }
                }).setNegativeButton("不懂", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this,"positive"+which,Toast.LENGTH_LONG);

            }
        }).show();

    }
}