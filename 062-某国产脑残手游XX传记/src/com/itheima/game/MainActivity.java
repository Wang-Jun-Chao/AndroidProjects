package com.itheima.game;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.itheima.alipay.PayInterface;

public class MainActivity extends Activity {
    private PayInterface pi;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = new Intent();
        intent.setAction("com.itheima.pangzhi");
        bindService(intent, new MyServiceConn(), BIND_AUTO_CREATE);

    }

    public void click(View view) throws RemoteException {
        // 调用运程服务的支付方法
        pi.pay();
    }

    class MyServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            // 使用AIDL中自动生成的方法来进行强转
            pi = PayInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
