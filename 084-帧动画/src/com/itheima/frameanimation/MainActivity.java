package com.itheima.frameanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private AnimationDrawable rocketAnimation;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView rocketImage = (ImageView) findViewById(R.id.iv);
        // 把帧动画的资源文件指定为iv的背景
        rocketImage.setBackgroundResource(R.drawable.frameanimation);
        // 获取iv的背景
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();

        rocketAnimation.start();
    }
}
