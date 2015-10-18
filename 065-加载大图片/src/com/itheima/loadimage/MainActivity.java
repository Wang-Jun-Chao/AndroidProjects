package com.itheima.loadimage;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

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
        // 解析图片时需要使用的参数都封装在这个对象中
        BitmapFactory.Options opt = new BitmapFactory.Options();
        // 不为像素申请内存，只获取图片宽高
        opt.inJustDecodeBounds = true;
        BitmapFactory.decodeFile("/sdcard/dog.jpg", opt);
        int imageWidth = opt.outWidth;
        int imageHeight = opt.outHeight;

        Display dp = getWindowManager().getDefaultDisplay();
        // 拿到屏幕宽高
        int screenWidth = dp.getWidth();
        int screenHeight = dp.getHeight();

        // 计算绽放比例
        int scale = 1;
        int scaleWidth = imageWidth / screenWidth;
        int scaleHeight = imageHeight / screenHeight;
        if (scaleWidth >= scaleHeight && scaleWidth >= 1) {
            scale = scaleWidth;
        } else if (scaleWidth < scaleHeight && scaleWidth >= 1) {
            scale = scaleHeight;
        }

        // 设置缩放比例
        opt.inSampleSize = scale;
        opt.inJustDecodeBounds = false;
        Bitmap bm = BitmapFactory.decodeFile("/sdcard/dog.jpg", opt);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(bm);
    }
}
