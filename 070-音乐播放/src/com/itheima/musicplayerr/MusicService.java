package com.itheima.musicplayerr;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

import java.io.IOException;

/**
 * Author: 王俊超
 * Date: 2015-10-19
 * Time: 07:36
 * Declaration: All Rights Reserved !!!
 */
public class MusicService extends Service {
    private MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicController();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 停止播放
        player.stop();
        // 释放占用资源，此时player对象已经废掉了
        player.release();
    }

    // 播放音乐
    public void play() {
        // 重置
        player.reset();
        try {
            // 加载多媒体文件
            player.setDataSource("/sdcard/mylove.mp3");
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 继续播放
    public void continuePlay() {
        player.start();
    }

    // 暂停播放
    public void pause() {
        player.pause();
    }

    class MusicController extends Binder implements MusicInterface {

        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void continuePlay() {
            MusicService.this.continuePlay();
        }

        @Override
        public void pause() {
            MusicService.this.pause();
        }

    }
}
