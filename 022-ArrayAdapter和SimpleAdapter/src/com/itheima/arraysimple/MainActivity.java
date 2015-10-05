package com.itheima.arraysimple;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        String[] objects = new String[]{
                "小志",
                "小志的儿子",
                "萌萌"
        };

        ListView lv = (ListView) findViewById(R.id.lv);

        // 使用ArrayAdapter
//        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.item_listview, R.id.tv_name, objects));

        // 使用SimpleAdapter
        // 集合中每个元素都包含ListView条目需要的所有数据，该案例中每个条目需要一个字符串和一个整数
        // 所以用一个Map来封装这两种数据
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.photo1);
        map1.put("name", "小志");
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.photo2);
        map2.put("name", "小志的儿子");
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.photo3);
        map3.put("name", "萌萌");
        data.add(map3);

        lv.setAdapter(new SimpleAdapter(this, data, R.layout.item_listview,
                new String[]{"photo", "name"}, new int[]{R.id.iv_photo, R.id.tv_name}));
    }
}
