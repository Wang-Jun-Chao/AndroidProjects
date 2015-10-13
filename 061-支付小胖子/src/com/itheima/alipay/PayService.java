package com.itheima.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Author: 王俊超
 * Date: 2015-10-13
 * Time: 09:05
 * Declaration: All Rights Reserved !!!
 */
public class PayService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new PayPangZhi();
    }

    public void pay() {
        System.out.println("正在检测环境");
        System.out.println("加密用户名密码");
        System.out.println("建立连接");
        System.out.println("上传数据");
        System.out.println("完成支付");
    }

    // 中间人对象
    class PayPangZhi extends PayInterface.Stub {

        @Override
        public void pay() throws RemoteException {
            // 调用服务的pay方法
            PayService.this.pay();
        }
    }
}
