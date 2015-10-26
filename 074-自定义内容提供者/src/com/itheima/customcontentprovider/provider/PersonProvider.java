package com.itheima.customcontentprovider.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
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
    // 创建Uri匹配器对象
    private static UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);

    // 检测其它用户输入的uri与匹配器中的哪条uri匹配
    static {
        um.addURI("com.itheima.people", "person", 1);
        um.addURI("com.itheima.people", "teacher", 2);
        um.addURI("com.itheima.people", "person/#", 3);
    }

    // 内容提供者创建时调用
    @Override
    public boolean onCreate() {
        oh = new MyOpenHelper(getContext());
        db = oh.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        if (um.match(uri) == 1) {
            return db.query("person", projection, selection, selectionArgs, null, null, sortOrder, null);
        } else if (um.match(uri) == 2) {
            return db.query("teacher", projection, selection, selectionArgs, null, null, sortOrder, null);
        } else if (um.match(uri) == 3) {
            // 把uri末尾携带的数字取出来
            long id = ContentUris.parseId(uri);
            return db.query("person", projection, "_id=?", new String[]{id + ""}, null, null, sortOrder, null);
        } else {
            throw new IllegalArgumentException("uri有问题");
        }
    }

    @Override
    public String getType(Uri uri) {

        if (um.match(uri) == 1) {
            return   "vnd.android.cursor.dir/person";
        } else if (um.match(uri) == 3) {
            return "vnd.android.cursor.item/person";
        }

        return null;
    }

    // 此方法供其它应用调用，用于往people数据库里插入数据
    // values: 由其它应用传入
    // uri: 内容提供者的主机名，也就是地址
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // 使用匹配器匹配传入的uri
        if (um.match(uri) == 1) {
            db.insert("person", null, values);

            // 发送数据改变通知
            // uri:通知发送到哪个uri上，所有注册到这个uri上的内容观察者都可以接收到这个通知
            getContext().getContentResolver().notifyChange(uri, null);
        } else if (um.match(uri) == 2) {
            db.insert("teacher", null, values);
            getContext().getContentResolver().notifyChange(uri, null);
        } else {
            throw new IllegalArgumentException("uri有问题");
        }
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
