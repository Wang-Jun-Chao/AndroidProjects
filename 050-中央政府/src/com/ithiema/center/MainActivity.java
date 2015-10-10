package com.ithiema.center;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
        // resultReceiver：不需要在清单文件中配置，该接收者只接收该条有序广播，
        // 并且是最后一个接收到该广播，并且一定可以接收到该广播
        sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, "每个人发100斤大米", null);
    }


    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String text = getResultData();
            System.out.println("反贪局收到文件：" + text);
        }
    }
}
