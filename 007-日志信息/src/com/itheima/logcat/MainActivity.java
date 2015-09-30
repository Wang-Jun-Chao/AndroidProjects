package com.itheima.logcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        System.out.println("小志，世界级AD西。");
//        System.out.println("好吃不过饺子");

        // 错误级别信息
        Log.e("上miss", "谁能赐我一shi");
        // 警告级别信息
        Log.w("上miss", "谁能赐我一shi");
        Log.i("上miss", "谁能赐我一shi");
        Log.d("上miss", "谁能赐我一shi");
        Log.v("上miss", "谁能赐我一shi");
    }
}
