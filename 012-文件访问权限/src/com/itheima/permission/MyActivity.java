package com.itheima.permission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click1(View view) {
        // 文件默认是应该内部存储空间的路径
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("info1.txt", MODE_PRIVATE);
            fos.write("哈哈哈哈".getBytes());

        } catch (Exception e) {
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

    public void click2(View view) {
        // 文件默认是应该内部存储空间的路径
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("info2.txt", MODE_WORLD_READABLE | MODE_WORLD_WRITEABLE);
            fos.write("哈哈哈哈".getBytes());

        } catch (Exception e) {
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

    public void click3(View view) {
        // 文件默认是应该内部存储空间的路径
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("info3.txt", MODE_WORLD_WRITEABLE | MODE_WORLD_READABLE);
            fos.write("德玛西亚".getBytes());

        } catch (Exception e) {
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
}
