package com.itheima.rwinouter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
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
        File file = new File(Environment.getExternalStorageDirectory(), "login.txt");
//        File file = new File("/sdcard/login.txt");
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            if (file.exists()) {

                BufferedReader fr = null;
                try {
                    fr = new BufferedReader(new FileReader(file));
                    // 读取txt文件里的用户名和密码
                    String line = fr.readLine();
                    String[] ss = line.split("##");

                    // 数据回显

                    et_name.setText(ss[0]);
                    et_pass.setText(ss[1]);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public void login(View view) {

        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        CheckBox cb = (CheckBox) findViewById(R.id.cb);
        // 判断选框是否被勾选
        if (cb.isChecked()) {
            // MDEIA_UNKNOWN：不能识别SD卡
            // MDEIA_REMOVED：没有SD卡
            // MEDIA_UNMOUNTED：SD卡存在，但是没有挂载
            // MEDIA_CHECKING：SD卡正在准备
            // MEDIA_MOUNTED：SD卡已经挂载，可用
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                // 内部存储空间的路径：getFilesDir() = /data/data/com.itheima.apirwinrom
                // 要保存的文件名：login.txt
                // 返回一个File对象，其路径是SD卡的真实路径
                File file = new File(Environment.getExternalStorageDirectory(), "login.txt");
//            File file = new File("/sdcard/login.txt");
                FileWriter fos = null;
                try {
                    fos = new FileWriter(file, false);
                    fos.write((name + "##" + pass));
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                Toast.makeText(this, "SD卡不可用", Toast.LENGTH_SHORT).show();
            }
        }

        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
