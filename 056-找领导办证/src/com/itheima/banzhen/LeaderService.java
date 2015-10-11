package com.itheima.banzhen;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 07:00
 * Declaration: All Rights Reserved !!!
 */
public class LeaderService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        // 返回一个IBinder对象，这是一个中间人对象
        return new ZhouMi();
    }

    public void banZheng() {
        System.out.println("李处来帮你办证");
    }

    class ZhouMi extends Binder implements PublicBusiness {
        @Override
        public void qianXian() {
            banZheng();
        }

        public void daMaJiang() {
            System.out.println("陪李处打麻将");
        }
    }
}
