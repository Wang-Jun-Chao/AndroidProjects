package com.itheima.recoder;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import java.io.IOException;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 21:40
 * Declaration: All Rights Reserved !!!
 */
public class RecorderService extends Service {
    private MediaRecorder recorder;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 拿到电话管理器
        TelephonyManager tm = (TelephonyManager) getSystemService(Service.TELEPHONY_SERVICE);

        // 监听电话状态
        tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
    }

    class MyListener extends PhoneStateListener {
        // 一旦电话状态改变，此方法被调用
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:
                    System.out.println("空闲");
                    if (recorder != null) {
                        recorder.stop();
                        recorder.release();
                        recorder = null;
                    }
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    System.out.println("响铃");
                    // 初始化录音机

                    if (recorder == null) {
                        recorder = new MediaRecorder();
                        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        recorder.setOutputFile("/sdcard/luyin.3gp");
                        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        try {
                            recorder.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("接机");
                    // 开始录音
                    break;
            }

        }
    }
}
