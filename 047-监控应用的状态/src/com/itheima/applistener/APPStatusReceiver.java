package com.itheima.applistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 11:47
 * Declaration: All Rights Reserved !!!
 */
public class APPStatusReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Uri uri = intent.getData();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            Toast.makeText(context, uri.toString() + "被安装了", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_PACKAGE_REPLACED.equals(action)) {
            Toast.makeText(context, uri.toString() + "被更新了", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
            Toast.makeText(context, uri.toString() + "被所载了", Toast.LENGTH_SHORT).show();
        }
    }
}
