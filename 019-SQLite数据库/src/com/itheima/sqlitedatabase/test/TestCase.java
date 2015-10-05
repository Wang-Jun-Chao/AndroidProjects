package com.itheima.sqlitedatabase.test;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import com.itheima.sqlitedatabase.MyOpenHelper;

/**
 * Author: 王俊超
 * Date: 2015-10-05
 * Time: 09:40
 * Declaration: All Rights Reserved !!!
 */
public class TestCase extends AndroidTestCase {
    public void test() {
        // getContext():获取一个虚拟上下文
        MyOpenHelper oh = new MyOpenHelper(getContext(), "people.db", null, 2);
        // 如果数据库对象不存在，先创建数据库，再获取可读可写数据库对象，如果已经存在，就直接获取数据库对象
        SQLiteDatabase db = oh.getWritableDatabase();
        // 如果存储空间满了，那么返回的只读数据库对象
//        SQLiteDatabase db = oh.getWritableDatabase();
    }

    public void insert() {
        MyOpenHelper oh = new MyOpenHelper(getContext(), "people.db", null, 2);
        SQLiteDatabase db = oh.getWritableDatabase();
//        db.execSQL("INSERT INTO person(name, salary, phone) VALUES('小志', '13000', 138438)");
        db.execSQL("INSERT INTO person(name, salary, phone) VALUES(?, ?, ?)", new Object[]{"小志", "13000", 138438});
    }
}
