package com.zanoni.streetracing;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Music extends Service {
    public static MediaPlayer player;
    private static Context context;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        player = MediaPlayer.create(context, R.raw.music);
        player.setLooping(true);
        player.setVolume(100, 100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try{
            player.start();
        }catch (Exception e){
            player.stop();
        }
        return 1;
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    public void onPause(){
        player.stop();
    }

    public void onStop(){
        player.stop();
    }
}
