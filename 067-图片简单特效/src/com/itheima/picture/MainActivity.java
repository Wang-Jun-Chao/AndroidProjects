package com.itheima.picture;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 这个对象是只读的
        Bitmap bmSrc = BitmapFactory.decodeFile("/sdcard/photo3.jpg");

        //创建图片副本
        // 1、在内存中创建一个与原图一模一样大小的bitmap对象，创建与原图一样的白纸
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        // 2、创建画笔对象
        Paint paint = new Paint();
        // 3、创建画板对象，把白纸铺在画板上
        Canvas canvas = new Canvas(bmCopy);
        // 4、开始作画，把原图的内容绘制在白纸上
        Matrix mt = new Matrix();

        // 平移
//        mt.setTranslate(20, 40);
        // 缩放
//        mt.setScale(2, 0.5F);
//        mt.setScale(0.5F, 0.5F, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
        // 旋转
//        mt.setRotate(45, bmCopy.getWidth() / 2, bmCopy.getHeight() / 2);
        // 镜面
//        mt.setScale(-1, 1);
//        mt.postTranslate(bmCopy.getWidth(), 0);
        // 镜面
        mt.setScale(1, -1);
        mt.postTranslate(0, bmCopy.getHeight());
        canvas.drawBitmap(bmSrc, mt, paint);

        canvas.drawLine(10, 10, 40, 40, paint);
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_src.setImageBitmap(bmSrc);
        iv_copy.setImageBitmap(bmCopy);
    }
}
