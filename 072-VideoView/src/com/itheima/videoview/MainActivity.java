package com.itheima.videoview;

import android.app.Activity;
import android.os.Bundle;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
//import android.widget.VideoView;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 检测是否支持vitamio
        if (!LibsChecker.checkVitamioLibs(this)) {
            return;
        }

//        VideoView vv = (VideoView) findViewById(R.id.vv);
        VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("/sdcard/vedio.rmvb");
        vv.start();

        vv.setMediaController(new MediaController(this));
    }
}
