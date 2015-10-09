package com.itheima.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

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
//        System.out.println("打电话广播收到，当当当！！！");
        // 在打电话广播中，会携带拨打电话的号码，通过以下代码获取到
        String number = getResultData();
        System.out.println(number);

        if (number.startsWith("0")) {
            SharedPreferences sp = context.getSharedPreferences("ip", Context.MODE_PRIVATE);
            String ipNumber = sp.getString("ipNumber", "");

            // 把IP线程号码添加至用户拨打号码的前面
            number = ipNumber + number;

            // 把新的号码重新放入广播中
            setResultData(number);
        }
    }
}
