package com.itheima.htmlviewer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.itheima.htmlviewer.utils.Utils;
import org.apache.http.HttpConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends Activity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            TextView tv = (TextView) findViewById(R.id .tv);
            tv.setText((String) msg.obj);
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click(View view) {

        Thread t = new Thread() {
            @Override
            public void run() {
                String path = "https://www.baidu.com/";
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    // 先建立连接，然后获取响应码
                    if (conn.getResponseCode() == 200) {
                        // 拿到服务器返回的输入流，流里的数据就是HTML文件
                        InputStream is = conn.getInputStream();
                        String text = Utils.getTextFormStream(is);

                        // 发送消息，让主线程刷新UI，显示源文件
                        Message msg = new Message();
                        msg.obj = text;
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
