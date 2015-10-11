package com.itheima.startservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 21:26
 * Declaration: All Rights Reserved !!!
 */
public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService.onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyService.onDestroy");;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService.onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}
