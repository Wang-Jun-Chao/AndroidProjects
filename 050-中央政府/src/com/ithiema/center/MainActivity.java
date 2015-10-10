package com.ithiema.center;

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
        intent.setAction("com.itheima.fdm");
        // 发送有序广播
        sendOrderedBroadcast(intent, null, null, null, 0, "每个人发100斤大米", null);
    }
}
