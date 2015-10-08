package com.itheima.senddata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click(View view) {
        Intent intent = new Intent();

        // 把数据封装至Intent对象中
        intent.putExtra("malename", "李志");
        intent.putExtra("femalename", "芙蓉姐姐");

        intent.setClass(this, SecondActivity.class);

        startActivity(intent);
    }
}
