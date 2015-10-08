package com.itheima.jump;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Author: 王俊超
 * Date: 2015-10-08
 * Time: 08:08
 * Declaration: All Rights Reserved !!!
 */
public class SecondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        // 获取到启动这个Activity的意图
        Intent intent = getIntent();
        Uri uri = intent.getData();
        System.out.println(uri.toString());

    }
}