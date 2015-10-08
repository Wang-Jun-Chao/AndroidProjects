package com.itheima.senddata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

/**
 * Author: 王俊超
 * Date: 2015-10-08
 * Time: 10:25
 * Declaration: All Rights Reserved !!!
 */
public class SecondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Intent intent = getIntent();
        // 从Intent对象中取出封装好的数据
//        String maleName = intent.getStringExtra("malename");
//        String femaleName = intent.getStringExtra("femalename");

        Bundle bundle = intent.getExtras();
        String maleName = bundle.getString("malename");
        String femaleName = bundle.getString("femalename");


        Random rd = new Random();
        int yinyuan = rd.nextInt(99);

        if ("zk".equals(maleName) && "xxx".equals(femaleName)) {
            yinyuan = 199;
        }

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(maleName + "和" + femaleName + "的姻缘值为：" + yinyuan);

    }
}