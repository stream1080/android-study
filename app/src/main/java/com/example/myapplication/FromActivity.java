package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FromActivity extends AppCompatActivity {

    private Button btn_from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from);

        btn_from = findViewById(R.id.btn_from);

        btn_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FromActivity.this,ToActivity.class);
//1修改标题                intent.putExtra("Transfer","第二个页面");

                Bundle bundle = new Bundle();
                bundle.putString("name","Tony");//传送字符串
                bundle.putInt("age",23);        //传送整形数据
                intent.putExtras(bundle);

                //返回结果
                startActivityForResult(intent,0);


//               Intent intent = new Intent();
//                intent.setComponent(new ComponentName(FromActivity.this,ToActivity.class));
//
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(FromActivity.this,"com.example.myapplication.ToActivity.class"));
//
//                intent.setComponent(new ComponentName(FromActivity.this,"com.example.myapplication.ToActivity.class"));
//
//                intent.setClass(FromActivity.this,ToActivity.class);
//
//                //隐式调用,清单文件中设置
//                intent.setAction("test.jump");
//                intent.addCategory("qq.sss");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断一下两个code，未写

        Toast.makeText(FromActivity.this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();


    }
}