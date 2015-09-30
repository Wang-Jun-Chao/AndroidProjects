package com.itheima.rwinrom;

import android.app.Activity;
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
        File file = new File("/data/data/com.itheima.rwinrom/login.txt");

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

    public void login(View view) {

        String name = et_name.getText().toString();
        String pass = et_pass.getText().toString();

        CheckBox cb = (CheckBox) findViewById(R.id.cb);
        // 判断选框是否被勾选
        if (cb.isChecked()) {
            // 内部存储空间的路径：/data/data/com.itheima.rwinrom/login.txt
            File file = new File("/data/data/com.itheima.rwinrom/login.txt");
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
        }

//        System.out.println("登录成功");
        // 创建吐司对话框，并且显示
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
