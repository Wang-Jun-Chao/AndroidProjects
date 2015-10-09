package com.itheima.selectcontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Author: 王俊超
 * Date: 2015-10-09
 * Time: 20:26
 * Declaration: All Rights Reserved !!!
 */
public class SmsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        ListView lv = (ListView) findViewById(R.id.lv);

        //虚构几条短信
        final String[] objects = {"正在开会，请稍后",
                "正在吃饭，别吵吵",
                "正在办正事，请勿打扰"};
        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_contact, R.id.tv, objects));

        // 对ListView条目进行点击侦听
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // i：用户点击了哪个条目
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent data = new Intent();
                // 把要传递的数据封闭至Intent对象
                data.putExtra("content", objects[i]);
                // 此Activity一旦销毁，这个data就会传递到此Activity的调用者
                setResult(0, data);
                finish();
            }
        });

    }
}