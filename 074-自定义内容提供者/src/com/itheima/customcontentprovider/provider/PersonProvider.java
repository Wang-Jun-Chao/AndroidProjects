package com.itheima.customcontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.itheima.customcontentprovider.MyOpenHelper;

/**
 * Author: 王俊超
 * Date: 2015-10-19
 * Time: 16:15
 * Declaration: All Rights Reserved !!!
 */
public class PersonProvider extends ContentProvider {
    private MyOpenHelper oh;
    private SQLiteDatabase db;

    // 内容提供者创建时调用
    @Override
    public boolean onCreate() {
        oh = new MyOpenHelper(getContext());
        db = oh.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
       return db.query("person", projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    @Override
    public String getType(Uri uri) {

        return null;
    }

    // 此方法供其它应用调用，用于往people数据库里插入数据
    // values: 由其它应用传入
    // uri: 内容提供者的主机名，也就是地址
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        db.insert("person", null, values);
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return db.delete("person", selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return db.update("person", values, selection, selectionArgs);
    }
}
