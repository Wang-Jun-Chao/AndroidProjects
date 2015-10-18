package com.itheima.siyifu;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Map;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.awaiyi);
        // 创建外衣图的副本
        final Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(bmCopy);
        canvas.drawBitmap(bmSrc, new Matrix(), paint);

        final ImageView iv = (ImageView) findViewById(R.id.iv);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) motionEvent.getX();
                        int y = (int) motionEvent.getY();


                        for (int i = -5; i <= 5; i++) {
                            for (int j = -5; j <= 5; j++) {

                                if (Math.sqrt(i * i + j * j) <= 5) {
                                    if (x + i < bmCopy.getWidth() && x + i >= 0
                                            && y + j < bmCopy.getHeight() && y + j >= 0) {
                                        // 把用户划过的坐标设置为透明色
                                        // 改变指定像素的颜色
                                        bmCopy.setPixel(x + i, y + j, Color.TRANSPARENT);
                                        iv.setImageBitmap(bmCopy);
                                    }
                                }
                            }
                        }
                        break;
                }
                return true;
            }
        });

    }
}
