package com.itheima.selectcontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private static final int CONTACT_LIST = 10;
    private static final int SMS_LIST = 20;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        // 启动选择联系人的Activity
//        startActivity(intent);
        // 告诉系统，这个Activity销毁时会返回数据
        startActivityForResult(intent, CONTACT_LIST);
    }

    public void click2(View view) {
        Intent intent = new Intent(this, SmsActivity.class);
        // 启动选择联系人的Activity
        // 告诉系统，这个Activity销毁时会返回数据
        startActivityForResult(intent, SMS_LIST);
    }

    // 当一个应该要返回数据的Activity被销毁时，此方法被调用，用于接收数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println(requestCode + ":" + resultCode);
        System.out.println(data.getStringExtra("name"));

        if (requestCode == CONTACT_LIST) {
            EditText et_name = (EditText) findViewById(R.id.et_name);
            et_name.setText(data.getStringExtra("name"));
        } else if (requestCode == SMS_LIST) {
            EditText et_content = (EditText) findViewById(R.id.et_content);
            et_content.setText(data.getStringExtra("content"));
        }


    }


}
