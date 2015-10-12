package com.itheima.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 08:21
 * Declaration: All Rights Reserved !!!
 */
public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            System.out.println("屏幕关闭");
        } else if (Intent.ACTION_SCREEN_ON.equals(action)) {
            System.out.println("屏幕打开");
        }
    }
}
