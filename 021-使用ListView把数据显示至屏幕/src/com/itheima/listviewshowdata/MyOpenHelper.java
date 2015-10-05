package com.itheima.listviewshowdata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: 王俊超
 * Date: 2015-10-05
 * Time: 09:33
 * Declaration: All Rights Reserved !!!
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "people.db", null, 1);
    }

    // 数据库创建时，此方法被调用
    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("CREATE TABLE person(_id INTEGER PRIMARY KEY AUTOINCREMENT, name CHAR(10), salary CHAR(20), phone INTEGER(10))");

    }

    // 数据库升级时，此方法被调用
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("数据库升级了");
    }
}
