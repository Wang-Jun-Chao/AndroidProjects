package com.itheima.listviewshowdata;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.itheima.domain.Person;
import com.itheima.listviewshowdata.MyOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Person> personList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        personList = new LinkedList<Person>();

        // 把数据库中的数据查询出来
        MyOpenHelper oh = new MyOpenHelper(this);
        SQLiteDatabase db = oh.getWritableDatabase();
        Cursor cursor = db.query("person", null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String salary = cursor.getString(cursor.getColumnIndex("salary"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));

            Person p = new Person(id, name, phone, salary);
            personList.add(p);
        }
        db.close();
        cursor.close();

        ListView lv = (ListView) findViewById(R.id.lv);


    }
}
