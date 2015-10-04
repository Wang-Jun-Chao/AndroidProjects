package com.itheima.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;

public class MainActivity extends Activity {
    private EditText et_name;
    private EditText et_pass;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        et_name = (EditText) findViewById(R.id.et_name);
        et_pass = (EditText) findViewById(R.id.et_pass);

        readAccount();
    }

    public void readAccount() {
        SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);

        if (sp != null) {
            String name = sp.getString("name", "");
            String pass = sp.getString("pass", "");

            et_name.setText(name);
            et_pass.setText(pass);
        }

    }

    public void login(View view) {

        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        CheckBox cb = (CheckBox) findViewById(R.id.cb);
        // 判断选框是否被勾选
        if (cb.isChecked()) {
            // 使用SharedPreference来保存用户名密码
            SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
            // 获取sp的编辑器
            SharedPreferences.Editor ed = sp.edit();
            ed.putString("name", name);
            ed.putString("pass", pass);
            // 提交
            ed.apply();


        }

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
