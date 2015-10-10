package com.itheima.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 20:41
 * Declaration: All Rights Reserved !!!
 */
public class ShengZF extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String text = getResultData();
        System.out.println("省政府收到文件：" + text);
        setResultData("每个发80斤大米");
    }
}
