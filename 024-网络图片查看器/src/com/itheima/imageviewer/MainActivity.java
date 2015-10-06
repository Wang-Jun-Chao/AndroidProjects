package com.itheima.imageviewer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    private static ImageView iv;
    private static MainActivity ma;

    private static Handler handler = new Handler() {
        // 此方法在主线程中调用，可以用来刷新UI
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0:
                    Toast.makeText(ma, "请求失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    // 把位图对象显示到ImageView
                    iv.setImageBitmap((Bitmap) msg.obj);
                    break;
            }
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        iv = (ImageView) findViewById(R.id.iv);

        ma = this;
    }

    public void click(View view) {

        Thread t = new Thread() {
            @Override
            public void run() {
                // 下载图片
                // 1、确定网址
                String path = "http://pic.qiantucdn.com/10/20/29/99bOOOPIC77.jpg";
                try {
                    // 2、把网址封闭成一个URL对象
                    URL url = new URL(path);
                    // 3、获取客户端和服务器连接对象，此时还没有建立连接
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    // 4、对链接对象进行初始化
                    // 设置请求方法，注意大写
                    conn.setRequestMethod("GET");
                    // 设置连接超时
                    conn.setConnectTimeout(5000);
                    // 设置读取超时
                    conn.setReadTimeout(5000);
                    // 5、发送请求，与服务器建立连接
                    conn.connect();
                    // 如果响应码为200
                    if (conn.getResponseCode() == 200) {
                        // 获取服务器响应头中的流，流里的数据就是客户端请求的数据
                        InputStream is = conn.getInputStream();
                        // 读取流里的数据，并构造出图片
                        Bitmap bm = BitmapFactory.decodeStream(is);


                        Message msg = new Message();
                        // 消息对像可以携带数据
                        msg.obj = bm;
                        msg.what = 1;
                        // 把消息发送至主线程的消息队列
                        handler.sendMessage(msg);
                    } else {
//                        Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
                        Message msg = handler.obtainMessage();
                        msg.what = 0;
                        handler.sendMessage(msg);
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        t.start();


    }
}
