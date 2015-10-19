package com.itheima.musicplayerr;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

    private MusicInterface mi;
    private MyServiceConn conn;
    private Intent intent;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        intent = new Intent(this, MusicService.class);
        conn = new MyServiceConn();
        bindService(intent, conn, BIND_AUTO_CREATE);
    }


    class MyServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mi = (MusicInterface) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    public void play(View view) {
        mi.play();
    }

    public void continuePlay(View view) {
        mi.continuePlay();
    }

    public void pause(View view) {
        mi.pause();
    }

    public void exist(View view) {
        mi.pause();
        unbindService(conn);
        stopService(intent);
    }
}
