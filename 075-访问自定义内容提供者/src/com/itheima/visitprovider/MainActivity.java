package com.itheima.visitprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void insert(View view) {
        // 通过内容提供者把数据插入数据库
        // 拿到ContentResolver
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("name", "小明");
        values.put("money", 13000);
        // url: 内容提供者的主要名
        // values: 要插入的数据
        cr.insert(Uri.parse("content://com.itheima.people"), values);

        values.put("name", "中明");
        values.put("money", 13000);
        cr.insert(Uri.parse("content://com.itheima.people"), values);

        values.put("name", "大明");
        values.put("money", 13000);
        cr.insert(Uri.parse("content://com.itheima.people"), values);

        values.put("name", "2B明");
        values.put("money", 13000);
        cr.insert(Uri.parse("content://com.itheima.people"), values);
    }

    public void delete(View view) {
        ContentResolver cr = getContentResolver();
        int i = cr.delete(Uri.parse("content://com.itheima.people"), "name=?", new String[]{"小明"});
        System.out.println(i);
    }

    public void update(View view) {
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("name", "SB明");
        int i = cr.update(Uri.parse("content://com.itheima.people"), values, "name=?", new String[]{"大明"});
        System.out.println(i);
    }

    public void query(View view) {
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(Uri.parse("content://com.itheima.people"), null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String money = cursor.getString(2);
            System.out.println(name + ":" + money);
        }

        cursor.close();
    }
}
