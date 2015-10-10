package com.itheima.sendcustomer;

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
         // 发送自定义广播
        Intent intent = new Intent();
        // 广播中的action也是自定义的
        intent.setAction("com.itheima.sendcustomer");
        sendBroadcast(intent);
    }
}
