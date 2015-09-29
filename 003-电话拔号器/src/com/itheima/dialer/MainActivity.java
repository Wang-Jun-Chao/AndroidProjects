package com.itheima.dialer;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 给按钮设置点击侦听
        // 1、拿到按钮对象
        Button bt = (Button) findViewById(R.id.bt_call);
        // 2设置侦听
        bt.setOnClickListener(new MyListener());


    }

    class MyListener implements View.OnClickListener {

        // 按钮被点击时，此方法调用
        @Override
        public void onClick(View view) {
//            System.out.println("按钮被点击了!");
            EditText et = (EditText) findViewById(R.id.et_text);
            // 获取用户输入的号码
            String phone = et.getText().toString();

            // 我们需要告诉系统，我们的动作，我要打电话
            // 创建意图对象
            Intent intent = new Intent();
            // 把动作封闭到意思对象中
            intent.setAction(Intent.ACTION_CALL);
            // 设置打给谁
            intent.setData(Uri.parse("tel:" + phone));

            // 把动作告诉系统
            startActivity(intent);

        }


    }
}
