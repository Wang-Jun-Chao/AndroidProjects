package com.itheima.jump;

import android.app.Activity;
import android.content.Intent;
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

    /**
     * 跳转至打电话的Activity
     * 跳转至其它应用的Activity
     * 隐式跳转：通过指定Activity和aata
     *
     * @param view
     */
    public void click1(View view) {
        Intent intent = new Intent();
        // 隐式意图
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:123456"));
        // 跳转
        startActivity(intent);
    }

    /**
     * 跳转至SecondActivity
     * 在本应用中跳转
     * 显示跳转：直接指定目标Activity的包名和类名
     *
     * @param view
     */
    public void click2(View view) {
        Intent intent = new Intent();
        // cls：直接指定目标Activity的class对象
        // 显示意图
        intent.setClass(this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * 显示跳转至拨号器
     *
     * @param view
     */
    public void click3(View view) {
        Intent intent = new Intent();
        intent.setClassName("com.android.contacts", "com.android.contacts.activities.DialtactsActivity");
        startActivity(intent);
    }

    /**
     * 隐示跳转至拔号器
     *
     * @param view
     */
    public void click4(View view) {
        Intent intent = new Intent();
        // 隐式设置拨号器的动作
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    /**
     * 隐示跳转至SenondActivity
     *
     * @param view
     */
    public void click5(View view) {
        Intent intent = new Intent();
        intent.setAction("com.itheima.jump.SecondActivity2");
        // 有scheme就要设置data
//        intent.setData(Uri.parse("heima2:qwe")) ;
        // 有mimeType就要设置type
//        intent.setType("text/username");

        // 如果scheme和mimeType都有，调用下面的方法
        intent.setDataAndType(Uri.parse("heima2:qwe"), "text/username");

        // 不写category，系统会添加一个默认的
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
    }
}
