package com.itheima.runremote;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

    private MyServiceConn conn;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        conn = new MyServiceConn();
    }

    public void click(View view) {
        // 启动远程服务
        Intent intent = new Intent();
        intent.setAction("com.itheima.remote");
        startService(intent);
    }

    public void click2(View view) {
        // 停止远程服务
        Intent intent = new Intent();
        intent.setAction("com.itheima.remote");
        stopService(intent);
    }

    public void click3(View view) {
        Intent intent = new Intent();
        intent.setAction("com.itheima.remote");
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void click4(View view) {
        unbindService(conn);
    }

    class MyServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
