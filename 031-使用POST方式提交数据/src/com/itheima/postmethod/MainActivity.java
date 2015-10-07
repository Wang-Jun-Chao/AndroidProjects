package com.itheima.postmethod;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.itheima.postmethod.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends Activity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
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
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);
        final String name = et_name.getText().toString();
        final String pass = et_pass.getText().toString();

        // 提交的数据要经过URL编码，英文和数字编码后不变

        final String path = "http://125.216.240.210:8080/web2/servlet/LoginServlet";

        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);

                    // 拼接出要提交的数据的字符串
                    String data = "name=" + URLEncoder.encode(name) + "&pass=" + pass;
                    System.out.println(data);
                    // 添加POST请求行的属性
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    conn.setRequestProperty("Content-Length", data.length() + "");

                    // 设置打开输出流
                    conn.setDoOutput(true);
                    // 拿到输出流
                    OutputStream os = conn.getOutputStream();
                    // 使用输出流往服务器提交数据
                    os.write(data.getBytes());
                    if (conn.getResponseCode() == 200) {
                        InputStream is = conn.getInputStream();
                        String text = Utils.getTextFormStream(is);

                        Message msg = handler.obtainMessage();
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
