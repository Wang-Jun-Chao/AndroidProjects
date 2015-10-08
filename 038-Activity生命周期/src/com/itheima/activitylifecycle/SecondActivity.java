package com.itheima.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;

/**
 * Author: 王俊超
 * Date: 2015-10-08
 * Time: 07:52
 * Declaration: All Rights Reserved !!!
 */
public class SecondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        System.out.println("SecondActivity.onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("SecondActivity.onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("SecondActivity.onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("SecondActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("SecondActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("SecondActivity.onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("SecondActivity.onRestart");
    }
}