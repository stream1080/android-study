package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tv5 = findViewById(R.id.tv5);//初始化
        tv5.getPaint().setFakeBoldText(true);//字体加粗
        tv5.getPaint().setStrikeThruText(true);//删除线
        tv5.getPaint().setUnderlineText(true);//下划线
        tv5.getPaint().setAntiAlias(true);//抗锯齿

        tv5.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG|Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
//       u下划线，s删除线，b粗体
        tv5.setText(Html.fromHtml("<u><s><b>雪崩的时候，没用一片雪花可以勇闯天涯</b></s></u>"));
    }
}