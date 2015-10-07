package com.itheima.httpclient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.itheima.httpclient.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class MainActivity extends Activity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
        }
    } ;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void get(View view) {
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);

        final String name = et_name.getText().toString();
        final String pass = et_pass.getText().toString();

        Thread t = new Thread() {
            @Override
            public void run() {

                String path = "http://125.216.240.210:8080/web2/servlet/LoginServlet?name="
                        + URLEncoder.encode(name) + "&pass=" + pass;
                // 使用HttpClient框架提交数据
                // 1、创建HttpClient对象
                HttpClient hc = new DefaultHttpClient();

                // 2、创建HttpGet对象，构造方法的参数就是网址
                HttpGet hg = new HttpGet(path);

                // 3、使用客户端对象，把GET请求对象发送出去
                try {
                    HttpResponse hr = hc.execute(hg);
                    // 拿到响应的状态行
                    StatusLine sl  = hr.getStatusLine();
                    if (sl.getStatusCode() == 200) {
                        // 拿到响应的实体行
                        HttpEntity he = hr.getEntity();
                        // 拿到实体中的内容，其实就是服务器返回的输入流
                        InputStream is = he.getContent();
                        String text = Utils.getTextFromStream(is);

                        // 发送消息让主线程刷新UI，显示登录结果
                        Message msg = handler.obtainMessage();
                        msg.obj = text;
                        handler.sendMessage(msg);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }

    public void post(View view) {
    }


}
