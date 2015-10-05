package com.itheima.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.alert_dark_frame);
        builder.setTitle("欲练此功必先自宫");
        builder.setMessage("李志平，想清楚哦");

        // 设置确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "感谢使用本软件，再见", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "若不自宫一定不成功", Toast.LENGTH_SHORT).show();
            }
        });

        // 使用一个创建器，生成一个对话框
        AlertDialog ad = builder.create();
        ad.show();

    }

    public void click2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择性别");
        final String[] items = new String[]{"男", "女"};
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            // which：用户所选条目的下标
            // dialog：触发事件的对话框
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择的是：" + items[which], Toast.LENGTH_SHORT).show();
                // 关闭对话框
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void click3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择认为帅的人");
        final String[] items = new String[]{"侃哥", "赵帅哥", "赵老师", "赵师兄"};
        final boolean[] checkedItems = new boolean[]{true, true, false, false};

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            // which：用户所选条目的下标
            // isChecked：用户选中该条目还是取消该条目
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
//                dialog.dismiss();
            }
        });

        // 设置确定按钮
        builder. setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = "";
                for (int i = 0; i < items.length; i++ ) {
                     if (checkedItems[i]) {
                         text += items[i] + ", ";
                     }
                }
                Toast.makeText(MainActivity.this, "你选择的是：" + text, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.show();
    }
}
