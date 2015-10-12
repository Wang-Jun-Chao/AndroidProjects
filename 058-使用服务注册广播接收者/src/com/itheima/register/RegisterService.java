package com.itheima.register;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 08:16
 * Declaration: All Rights Reserved !!!
 */
public class RegisterService extends Service {
    private ScreenReceiver receiver;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 注册广播接收者
        // 1、创建广播接收者对象
        receiver = new ScreenReceiver();
        // 2、创建IntentFilter对象
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        // 3、注册广播接收者
        registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 解除广播接收者
        unregisterReceiver(receiver);
    }
}
