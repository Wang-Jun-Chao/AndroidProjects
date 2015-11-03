package com.itheima.senddata;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private Fragment03 fg3;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 把fragment的界面显示至帧布局中
        // 创建fragment对象
        fg3 = new Fragment03();
        // 获取fragment管理器
        FragmentManager fm = getFragmentManager();
        // 打开事物
        FragmentTransaction ft = fm.beginTransaction();
        // 把内容显示至帧布局
        ft.replace(R.id.fl, fg3);
        // 提交
        ft.commit();
    }

    public void click1(View view) {
        // 把fragment的界面显示至帧布局中
        // 创建fragment对象
        Fragment01 fg1 = new Fragment01();
        // 获取fragment管理器
        FragmentManager fm = getFragmentManager();
        // 打开事物
        FragmentTransaction ft = fm.beginTransaction();
        // 把内容显示至帧布局
        ft.replace(R.id.fl, fg1);
        // 提交
        ft.commit();

    }

    public void click2(View view) {
        // 把fragment的界面显示至帧布局中
        // 创建fragment对象
        Fragment02 fg2 = new Fragment02();
        // 获取fragment管理器
        FragmentManager fm = getFragmentManager();
        // 打开事物
        FragmentTransaction ft = fm.beginTransaction();
        // 把内容显示至帧布局
        ft.replace(R.id.fl, fg2);
        // 提交
        ft.commit();
    }

    public void click3(View view) {
        // 把fragment的界面显示至帧布局中
        // 创建fragment对象
//        Fragment03 fg = new Fragment03();
        // 获取fragment管理器
        FragmentManager fm = getFragmentManager();
        // 打开事物
        FragmentTransaction ft = fm.beginTransaction();
        // 把内容显示至帧布局
        ft.replace(R.id.fl, fg3);
        // 提交
        ft.commit();
    }

    public void click4(View view) {
        EditText et_main = (EditText) findViewById(R.id.et_main);
        String text = et_main.getText().toString();

        // 传递数据
        fg3.setText(text);
    }

    public void setText(String text) {
        EditText et_main = (EditText) findViewById(R.id.et_main);
        et_main.setText(text);
    }
}
