package com.itheima.smsfirewall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/**
 * Author: 王俊超
 * Date: 2015-10-10
 * Time: 08:07
 * Declaration: All Rights Reserved !!!
 */
public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        System.out.println("系统收到短信啦啦啦。。。。");
        // 短信内容封闭在intent中
        Bundle bundle = intent.getExtras();
        // 以puds为键，取出一个object数组，数组中的每一个元素，都是一条短信
        Object[] objects = (Object[]) bundle.get("pdus");

        // 拿到广播中的所有短信
        for (Object object : objects) {
            // 通过pud来构造短信
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) object);

            if (sms.getOriginatingAddress().equals("138438")) {
                // 阻止其它广播接收者收到这条短信
                abortBroadcast();
            }

            System.out.println(sms.getOriginatingAddress());
            System.out.println(sms.getMessageBody());
        }
    }
}
