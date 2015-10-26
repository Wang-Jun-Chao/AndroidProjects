package com.itheima.listener;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getContentResolver().registerContentObserver(Uri.parse("content://com.itheima.people"),
                true, new ContentObserver(new Handler()){
                    @Override
                    public void onChange(boolean selfChange) {
                        super.onChange(selfChange);
                        System.out.println("074项目的数据库发了改变");
                    }
                });
    }
}
