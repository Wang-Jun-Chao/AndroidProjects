package com.itheima.recoder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 22:10
 * Declaration: All Rights Reserved !!!
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 启动录音机服务
        Intent it = new Intent(context, RecorderService.class);
        context.startService(it);
    }
}
