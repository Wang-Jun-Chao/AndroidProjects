package com.itheima.receivecustomer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 20:05
 * Declaration: All Rights Reserved !!!
 */
public class CustomerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "成功接收到广播", Toast.LENGTH_SHORT).show();
    }
}
