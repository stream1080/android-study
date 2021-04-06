package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.widge.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView showText;
    private Button btn_event_1;

    private Button btn_anonymous,btn_inner,btn_outer;
    private MyButton btn_mybutton;
    private TextView tv_event;
    private OuterEvent outerEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        showText = findViewById(R.id.showText);
        btn_anonymous = findViewById(R.id.btn_anonymous);
        tv_event = findViewById(R.id.tv_event);
        btn_inner = findViewById(R.id.btn_inner);
        btn_outer = findViewById(R.id.btn_outer);
        btn_mybutton = findViewById(R.id.btn_mybutton);

        //匿名内部类
        btn_anonymous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("匿名内部类", "onClick: ");
                tv_event.setText(btn_anonymous.getText() + "：被点击了");
            }
        });

        //初始化
        OnClicker onClicker = new OnClicker();

        //注册监听器，参数是对象
        btn_inner.setOnClickListener(onClicker);
        //初始化外部类

        outerEvent = new OuterEvent(tv_event);
        btn_outer.setOnClickListener(outerEvent);
        btn_mybutton.setOnClickListener(onClicker);

        btn_event_1 = findViewById(R.id.btn_event_1);
        //注册监听器
        btn_event_1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(EventActivity.this,"登录成功",Toast.LENGTH_LONG).show();
        showText.setText("欢迎光临星斗大森林");
    }

    public void 标签方式(View v) {
        tv_event.setText(((Button)v).getText()+ "：被点击率了" );
    }

    public void showtext(View view) {
    }

    class OnClicker implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.i("Onclik", "onClick: Mybutton");
            tv_event.setText(((Button)v).getText()+ "inner：被点击了" );
        }
    }
}