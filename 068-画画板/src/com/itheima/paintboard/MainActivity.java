package com.itheima.paintboard;

import android.app.Activity;
import android.graphics.*;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private ImageView iv;
    private Paint paint;
    private Canvas canvas;
    private Bitmap bmCopy;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 加载画画板的背景图
        Bitmap bmSrc = BitmapFactory.decodeResource(getResources(), R.drawable.bg);

        // 创建背景图的副本，纸
        bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        paint = new Paint();
        // 板
        canvas = new Canvas(bmCopy);
        // 绘制
        canvas.drawBitmap(bmSrc, new Matrix(), paint);

        iv = (ImageView) findViewById(R.id.iv);
        iv.setImageBitmap(bmCopy);

        // 设置触摸侦听
        iv.setOnTouchListener(new View.OnTouchListener() {

            private int startX;
            private int startY;

            // 触摸屏幕时，触摸事件产生时，此方法调用
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    // 用户手指摸到屏幕
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    // 手指正在滑动
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        canvas.drawLine(startX, startY, x, y, paint);
                        iv.setImageBitmap(bmCopy);
                        // 每一次的结束位置作为下一次的开始位置
                        startX = x;
                        startY = y;
                        break;
                    // 用户手指离开屏幕
                    case MotionEvent.ACTION_UP:
                        break;
                }
                // true：告诉系统，这个事件由我来处理
                // false：告诉系统，这个事件我不处理。这时触摸事件会把事件传递给父节点
                return true;
            }
        });
    }

    public void red(View view) {
        paint.setColor(Color.RED);
    }

    public void green(View view) {
        paint.setColor(Color.GREEN);

    }

    public void brush(View view) {
        paint.setStrokeWidth(7);
    }
}
