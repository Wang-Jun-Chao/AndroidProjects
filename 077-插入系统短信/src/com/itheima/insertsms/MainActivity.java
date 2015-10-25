package com.itheima.insertsms;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
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

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ContentResolver cr = getContentResolver();
                ContentValues values = new ContentValues();
                values.put("address", "95555");
                values.put("type", "1");
                values.put("date", System.currentTimeMillis());
                values.put("body", "你收到1,000,000RMB元的转帐，请注意查收。");
                cr.insert(Uri.parse("content://sms"), values);
            }
        };

        t.start();

    }

}
