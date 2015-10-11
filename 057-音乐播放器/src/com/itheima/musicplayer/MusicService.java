package com.itheima.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 07:47
 * Declaration: All Rights Reserved !!!
 */
public class MusicService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new MusicController();
    }

    public void play() {
        System.out.println("播放音乐");
    }

    public void pause() {
        System.out.println("暂停播放");
    }

    // 必须继承Binder，才能作为中间人返回
    class MusicController extends Binder implements MusicInterface {
        @Override
        public void play() {
            MusicService.this.play();
        }

        @Override
        public void pause() {
            MusicService.this.play();
        }
    }
}
