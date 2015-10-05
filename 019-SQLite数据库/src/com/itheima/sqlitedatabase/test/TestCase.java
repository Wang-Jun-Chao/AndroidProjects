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
    // 此时测试框架还没有初始化完毕，没有虚拟上下文对象
    private MyOpenHelper oh;
    private SQLiteDatabase db;

    // 测试框架初始化完毕后，在测试方法执行之前，此方法调用
    @Override
    protected void setUp() throws Exception {
        oh = new MyOpenHelper(getContext(), "people.db", null, 2);
        db = oh.getWritableDatabase();
    }

    // 在测试方法执行完毕后此方法被调用
    @Override
    protected void tearDown() throws Exception {
        db.close();
    }

    public void test() {
        // getContext():获取一个虚拟上下文
//        MyOpenHelper oh = new MyOpenHelper(getContext(), "people.db", null, 2);
        // 如果数据库对象不存在，先创建数据库，再获取可读可写数据库对象，如果已经存在，就直接获取数据库对象
//        SQLiteDatabase db = oh.getWritableDatabase();
        // 如果存储空间满了，那么返回的只读数据库对象
//        SQLiteDatabase db = oh.getWritableDatabase();
    }

    public void testInsert() {
//        MyOpenHelper oh = new MyOpenHelper(getContext(), "people.db", null, 2);
//        SQLiteDatabase db = oh.getWritableDatabase();
//        db.execSQL("INSERT INTO person(name, salary, phone) VALUES('小志', '13000', 138438)");
        db.execSQL("INSERT INTO person(name, salary, phone) VALUES(?, ?, ?)", new Object[]{"小志的老婆[1]", "13000", 138438});
//        db.execSQL("INSERT INTO person(name, salary, phone) VALUES(?, ?, ?)", new Object[]{"小志的儿子", 14000, "138888"});
//        db.close();
    }

    public void testDelete() {
//        MyOpenHelper oh = new MyOpenHelper(getContext(), "people.db", null, 2);
//        SQLiteDatabase db = oh.getWritableDatabase();
        db.execSQL("DELETE FROM person WHERE name = ?", new Object[]{"小志"});
//        db.close();
    }

    public void testUpdate() {
        db.execSQL("UPDATE person SET phone = ? WHERE name= ?", new Object[]{"186666", "小志的儿子"});
    }
}
