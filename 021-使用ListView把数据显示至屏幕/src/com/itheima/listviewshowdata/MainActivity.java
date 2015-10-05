package com.itheima.listviewshowdata;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        lv.setAdapter(new MyAdapter());

    }

    class MyAdapter extends BaseAdapter {

        // 系统调用，用来获知集合中有多少条元素
        @Override
        public int getCount() {
            return personList.size();
        }

        // 由系统调用，返回一个View对象，作为ListView对象的条目
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Person p = personList.get(i);

            System.out.println("getView调用：" + i);
//            TextView tv = new TextView(MainActivity.this);
//            tv.setText(p.toString());
//            tv.setTextSize(18);

            // 第一种：把布局文件转换成一个View对象

            View v = null;
            if (view == null) {
                v = View.inflate(MainActivity.this, R.layout.item_listview, null);
            } else {
                v = view;
            }

//            // 第二种：获取布局填充器对象
//            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
//            // 使用布局填充器对象填充布局文件
//            View v2 = inflater.inflate(R.layout.item_listview, null);

            // 第三种
//            LayoutInflater inflater2 = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//            View v3 = inflater2.inflate(R.layout.item_listview, null);

            // 通过资源Id查找组件，是TextView对象的findViewById
            TextView tv_name = (TextView) v.findViewById(R.id.tv_name);
            tv_name.setText("名字：" + p.getName());
            TextView tv_phone = (TextView) v.findViewById(R.id.tv_phone);
            tv_phone.setText("电话：" + p.getPhone());
            TextView tv_salary = (TextView) v.findViewById(R.id.tv_salary);
            tv_salary.setText("薪水：" + p.getSalary());
            return v;
        }

        @Override
        public Object getItem(int i) {
            return personList.get(i);
        }


        @Override
        public long getItemId(int i) {
            return i;
        }

    }
}
