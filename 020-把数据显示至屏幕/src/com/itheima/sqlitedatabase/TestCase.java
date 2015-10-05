package com.itheima.sqlitedatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import com.itheima.showdata.MyOpenHelper;

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
        oh = new MyOpenHelper(getContext());
        db = oh.getWritableDatabase();
    }

    // 在测试方法执行完毕后此方法被调用
    @Override
    protected void tearDown() throws Exception {
        db.close();
    }

    public void testInsertApi() {
        // 把要插入的数据全部封装到ContentValues对象中
        for (int i = 0; i < 50; i++) {
            ContentValues values = new ContentValues();
            values.put("name", "赵" + i);
            values.put("phone", "159" + i + i);
            values.put("salary", "160" + i + i);
            db.insert("person", null, values);
        }
    }
}
