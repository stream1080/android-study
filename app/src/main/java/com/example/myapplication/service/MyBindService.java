package com.example.myapplication.service;

import android.app.MediaRouteActionProvider;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

public class  MyBindService extends Service {
    private MyBinder myBinder;
    private MediaPlayer mp;


    protected class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }

        public void playMusic(String path){
            try {
                AssetFileDescriptor afd = getAssets().openFd(path);
                mp = new MediaPlayer();
                mp.reset();
                mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                mp.prepare();
                mp.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        myBinder = new MyBinder();
        return myBinder;
    }


}
