package com.itheima.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author: 王俊超
 * Date: 2015-10-09
 * Time: 22:08
 * Declaration: All Rights Reserved !!!
 */
public class CallReceiver extends BroadcastReceiver {
    // 接收到广播应就会调用
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("打电话广播收到，当当当！！！");
    }
}
