package com.itheima.smartimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.loopj.android.image.SmartImageView;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click(View view) {
        // 下载图片
        // 1、确定网址
        String path = "http://pic.qiantucdn.com/10/20/29/99bOOOPIC77.jpg";
        // 2、找到智能图片查看器对象
        SmartImageView siv = (SmartImageView) findViewById(R.id.iv);
        // 3、下载并显示图片
        siv.setImageUrl(path);
    }
}
