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
        System.out.println("开机成功");
        Toast.makeText(context, "开机成功", Toast.LENGTH_SHORT).show();
    }
}
