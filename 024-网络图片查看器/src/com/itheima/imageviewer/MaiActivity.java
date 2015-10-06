package com.itheima.imageviewer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MaiActivity extends Activity {
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
                Bitmap bm = BitmapFactory .decodeStream(is);
                ImageView iv = (ImageView) findViewById(R.id.iv);
                // 把位图对象显示到ImageView
                iv.setImageBitmap(bm);
            } else {
                Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
