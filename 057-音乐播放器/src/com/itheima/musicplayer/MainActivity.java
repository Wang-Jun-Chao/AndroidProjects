package com.itheima.musicplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

    private MusicInterface mi;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = new Intent(this, MusicService.class);
        // 混合调用
        // 为了把服务变成服务进程
        startService(intent);
        // 为了拿到中间人对象
        bindService(intent, new MusicServiceConn(), BIND_AUTO_CREATE);
    }

    // 开始播放按钮
    public void play(View view) {
        mi.play();
    }

    // 暂停播放按钮
    public void pause(View view) {
        mi.pause();
    }

    class MusicServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mi = (MusicInterface) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
