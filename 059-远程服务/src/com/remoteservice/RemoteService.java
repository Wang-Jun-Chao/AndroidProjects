package com.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/**
 * Author: 王俊超
 * Date: 2015-10-12
 * Time: 09:10
 * Declaration: All Rights Reserved !!!
 */
public class RemoteService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("RemoteService.onBind");
        return new FuRong();
    }

//    @Override
//    public boolean onUnbind(Intent intent) {
//        System.out.println("RemoteService.onUnbind");
//        return super.onUnbind(intent);
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        System.out.println("RemoteService.onCreate");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        System.out.println("RemoteService.onDestroy");
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        System.out.println("RemoteService.onStartCommand");
//        return super.onStartCommand(intent, flags, startId);
//    }

    public void banZheng() {
        System.out.println("李局来帮你办证");
    }

    class FuRong extends Binder implements PublicBusiness {

        @Override
        public void qianXian() {
            banZheng();
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }
}
