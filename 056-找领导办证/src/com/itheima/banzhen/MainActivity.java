package com.itheima.banzhen;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {
    private Intent intent;
    private ServiceConnection conn;
    private PublicBusiness pb;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        intent = new Intent(this, LeaderService.class);
        conn = new MyServiceConn();
        // 绑定领导服务
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void click(View view) {
        // 调用服务的办证方法
        pb.qianXian();
    }

    class MyServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pb = (PublicBusiness) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

}
