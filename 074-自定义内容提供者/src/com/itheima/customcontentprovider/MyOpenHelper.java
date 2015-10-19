package com.itheima.customcontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: 王俊超
 * Date: 2015-10-19
 * Time: 15:56
 * Declaration: All Rights Reserved !!!
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(context, "person.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person(_id integer PRIMARY KEY AUTOINCREMENT, name CHAR(10), money INTEGER(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
