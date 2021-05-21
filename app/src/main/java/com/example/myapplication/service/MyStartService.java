package com.example.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartService extends Service {
    private final String TAG = "MyStartService";
    private int iCreate = 0,iStart = 0;
    public MyStartService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        iCreate += 1;
        //只执行一次
        Log.i(TAG, "onCreate: "+iCreate);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        iStart += 1;
        //每次都执行
        Log.i(TAG, "onStartCommand: "+ iStart+Thread.currentThread());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}