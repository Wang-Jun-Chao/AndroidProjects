package com.itheima.clickevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("第一个按钮被点击");
            }
        });

        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("第二个按钮被点击");
    }

    // View：系统会把触发这个事件的对象传递进来
    public void getScore(View v) {
        // 通过对View对象进判断，用户就可以知道用户点击的到底是哪一个对象
        switch (v.getId()) {
            case R.id.king:
                System.out.println("下辈子吧");
                break;
            case R.id.diamond:
                System.out.println("凑合凑合");
                break;
            case R.id.master:
                System.out.println("想想就好");
                break;
        }
//        System.out.println("上不去了哎哎");
    }
}
