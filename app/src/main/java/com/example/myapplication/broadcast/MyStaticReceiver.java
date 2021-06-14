package com.example.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyStaticReceiver extends BroadcastReceiver {
    /**
     * 自定义的广播接收器
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"静态广播",Toast.LENGTH_LONG).show();
    }
}
