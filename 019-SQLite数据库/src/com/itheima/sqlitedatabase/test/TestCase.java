package com.itheima.sqlitedatabase.test;

import android.content.ContentValues;
import android.database.Cursor;
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
        db.execSQL("INSERT INTO person(name, salary, phone) VALUES('小志', '13000', 138438)");
//        db.execSQL("INSERT INTO person(name, salary, phone) VALUES(?, ?, ?)", new Object[]{"小志的老婆[1]", "13000", 138438});
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

    public void testSelect() {
        Cursor cursor = db.rawQuery("SELECT name, salary FROM person", null);
        while (cursor.moveToNext()) {
            // 通过列索引获取列的值
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String salary = cursor.getString(cursor.getColumnIndex("salary"));
            System.out.println(name + "=" + salary);
        }

        cursor.close();
    }

    public void testInsertApi() {
        // 把要插入的数据全部封装到ContentValues对象中
        ContentValues values = new ContentValues();
        values.put("name", "游天龙");
        values.put("phone", "159999");
        values.put("salary", 16000);
        db.insert("person", null, values);
    }

    public void testDeleteApi() {
        int i = db.delete("person", "name = ? AND _id = ?", new String[]{"小志的儿子", "3"});
        System.out.println(i);
    }

    public void testUpdateApi() {
        ContentValues values = new ContentValues();
        values.put("salary", 26000);
        int i = db.update("person", values, "name = ?", new String[]{"游天龙"});
        System.out.println(i);
    }

    public void testQueryApi() {
        Cursor cursor = db.query("person", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            String salary = cursor.getString(cursor.getColumnIndex("salary"));
            System.out.println(name + ", " + phone + ", " + salary);
        }
    }

    public void testTransaction() {
        try {
            // 开启事物
            db.beginTransaction();
            ContentValues values = new ContentValues();
            values.put("salary", 12000);
            db.update("person", values, "name=?", new String[]{"小志"});

            values.clear();
            values.put("salary", 15000);
            db.update("person", values, "name=?", new String[]{"小志的儿子"});

            // 设置事务执行成功
            db.setTransactionSuccessful();

        } finally {
            // 关闭事务，如果已经设置事物成功就提交，否则回滚
            db.endTransaction();
        }
    }
}
