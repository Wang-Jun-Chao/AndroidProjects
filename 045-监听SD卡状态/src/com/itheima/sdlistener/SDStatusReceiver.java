package com.itheima.sdlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 09:37
 * Declaration: All Rights Reserved !!!
 */
public class SDStatusReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 判断收到的是什么广播
        String action = intent.getAction();

        if (Intent.ACTION_MEDIA_MOUNTED.equals(action)) {
            Toast.makeText(context, "SD卡可用", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_MEDIA_REMOVED.equals(action)) {
            Toast.makeText(context, "SD卡拔出", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_MEDIA_UNMOUNTED.equals(action)) {
            Toast.makeText(context, "SD卡不可用", Toast.LENGTH_SHORT).show();
        }
    }
}
