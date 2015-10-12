package com.itheima.runremote;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.itheima.remoteservice.PublicBusiness;

public class MainActivity extends Activity {

    private MyServiceConn conn;
    private PublicBusiness pb;

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

    public void click5(View view) {
        try {
            pb.qianXian();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    class MyServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 把中间人对象强转为PublicBusiness对象
            pb = PublicBusiness.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}
