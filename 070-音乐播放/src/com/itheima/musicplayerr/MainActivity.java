package com.itheima.musicplayerr;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends Activity {
    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            int duration = bundle.getInt("duration");
            int currentPosition = bundle.getInt("currentPosition");
            // 刷新进度条
            sb.setMax(duration);
            sb.setProgress(currentPosition);
        }
    };

    private MusicInterface mi;
    private MyServiceConn conn;
    private Intent intent;
    private static SeekBar sb;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        sb = (SeekBar) findViewById(R.id.sb);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                System.out.println("手指按下");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                System.out.println("手指按下");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 根据拖动进度，设置音乐播放进度
                int progress = seekBar.getProgress();
                // 改变播放进度
                mi.seekTo(progress);
//                System.out.println("手指抬起");
            }
        });
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
