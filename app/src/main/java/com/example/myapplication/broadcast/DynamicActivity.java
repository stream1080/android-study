package com.example.myapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class DynamicActivity extends AppCompatActivity {

    private Button btn_dynamic;
    private static TextView tv_dynamic;
    private MyDynamicReceiver myDynamicReceiver;
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        btn_dynamic = findViewById(R.id.btn_dynamic);
        tv_dynamic = findViewById(R.id.tv_dynamic);

        localBroadcastManager = LocalBroadcastManager.getInstance(DynamicActivity.this);

        //动态注册
        myDynamicReceiver = new MyDynamicReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("new dynamic");
        localBroadcastManager.registerReceiver(myDynamicReceiver,intentFilter);

        btn_dynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("new Dynamic Broad");
                intent.putExtra("dynamic","动态广播");
//                intent.setPackage(getPackageName());//本地广播不用加包名
                localBroadcastManager.sendBroadcast(intent);
            }
        });

    }

    private static class MyDynamicReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            intent.getStringExtra("dynamic");
            tv_dynamic.setText(intent.getStringExtra("dynamic"));
        }
    }

    /**
     * 动态注册的广播，一定要销毁掉
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myDynamicReceiver);
    }
}