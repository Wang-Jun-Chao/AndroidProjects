package com.itheima.runservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-11
 * Time: 21:14
 * Declaration: All Rights Reserved !!!
 */
public class MyService extends Service {
    // 绑定时调用
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("MyService.onBind");
        return null;
    }

    // 解绑时调用
    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("MyService.onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService.onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("MyService.onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("MyService.onDestroy");
    }

    public void a() {
        System.out.println("可爱的小胖子");
    }
}
