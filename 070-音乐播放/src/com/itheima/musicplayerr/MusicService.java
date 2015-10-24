package com.itheima.musicplayerr;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.*;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: 王俊超
 * Date: 2015-10-19
 * Time: 07:36
 * Declaration: All Rights Reserved !!!
 */
public class MusicService extends Service {
    private MediaPlayer player;
    private Timer timer;

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
        player = null;
        if (timer != null) {
            timer.cancel();
            timer = null;
        }

    }

    // 播放音乐
    public void play() {
        // 重置
        player.reset();
        try {
            // 加载多媒体文件
            player.setDataSource("/sdcard/mylove.mp3");
            player.prepare();
//            player.start();


//            player.setDataSource("http://192.168.2.120:8080/mylove.mp3");
//            player.prepareAsync();
            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                // 准备完毕 ，此方法调用
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    player.start();
                    addTimer();
                }
            });
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

    public void seekTo(int progress) {
        player.seekTo(progress);
    }

    // 获取持续时间
    public void addTimer() {

        // 已经创建过和Timer对象就不再创建对象了
        if (timer != null) {
            return;
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 获取歌曲的总时长
                int duration = player.getDuration();
                // 获取当前播放进度
                int currentPosition = player.getCurrentPosition();
                Message msg = MainActivity.handler.obtainMessage();
                // 把消息封装至消息对象中
                Bundle bundle = new Bundle();
                bundle.putInt("duration", duration);
                bundle.putInt("currentPosition", currentPosition);
                msg.setData(bundle);
                MainActivity.handler.sendMessage(msg);

            }
            // 开始计时任务后的5毫秒，第一次执行run方法，以后每500毫秒执行一次
        }, 5, 500);
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

        @Override
        public void seekTo(int progress) {
            MusicService.this.seekTo(progress);
        }

    }
}
