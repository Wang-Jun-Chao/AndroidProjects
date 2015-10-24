package com.itheima.vedioplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class MainActivity extends Activity {
    private MediaPlayer player;
    private static int currentPosition = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SurfaceView sv = (SurfaceView) findViewById(R.id.sv);
        // 拿到SurfaceView的控制器
        final SurfaceHolder sh = sv.getHolder();

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        MediaPlayer player = new MediaPlayer();
//                        player.reset();
//                        try {
//                            player.setDataSource("/sdcard/vedio.3gp");
//                            player.setDisplay(sh);
//                            player.prepare();
//                            player.start();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        }.start();

        sh.addCallback(new SurfaceHolder.Callback() {
            // 创建时调用
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                if (player != null) {
                    return;
                }

                player = new MediaPlayer();
                player.reset();
                try {
                    player.setDataSource("/sdcard/vedio.3gp");
                    player.setDisplay(sh);
                    player.prepare();
                    player.start();
                    player.seekTo(currentPosition);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // SurfaceView结构改变时调用
            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

            }

            // 销毁时调用
            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                // 销毁时停止视频
                if (player != null) {
                    currentPosition = player.getCurrentPosition();
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });
    }
}
