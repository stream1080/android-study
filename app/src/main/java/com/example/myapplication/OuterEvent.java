package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OuterEvent implements View.OnClickListener {

    private TextView mTv;
    public OuterEvent(TextView textView){
        mTv = textView;
    }
    @Override
    public void onClick(View v) {
        mTv.setText(((Button)v).getText() + "Outer被点击了");
    }
}
