package com.itheima.smssender;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void send(View v) {
        // 拿到用户输入的号码和内容
        EditText et_phone = (EditText) findViewById(R.id.et_phone);
        EditText et_content = (EditText) findViewById(R.id.et_content);

        String phone = et_phone.toString();
        String content = et_content.toString();

        // 发送短信
        // 1、获取短信管理器
        SmsManager sm = SmsManager.getDefault();

        // 2、发送短信
        // 2.1、切割短信，把长短分成若干个小短信
        ArrayList<String> smss= sm.divideMessage(content);
        // 3、for循环把集合中的所有短信全部都发送出去
        for (String s: smss) {
            sm.sendTextMessage(phone, null, s, null, null);
        }
    }
}
