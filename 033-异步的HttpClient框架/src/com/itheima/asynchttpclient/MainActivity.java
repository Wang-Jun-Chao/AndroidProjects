package com.itheima.asynchttpclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;

import java.net.URLEncoder;

public class MainActivity extends Activity {
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


        String url = "http://125.216.240.210:8080/web2/servlet/LoginServlet?name="
                + URLEncoder.encode(name) + "&pass=" + pass;

        // 创建异步HttpClient
        AsyncHttpClient ahc = new AsyncHttpClient();

        // 发送Get请求提交数据
        ahc.get(url, new MyResponseHandler());
    }

    class MyResponseHandler extends AsyncHttpResponseHandler {

        // 请求成功时此方法调用
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            Toast.makeText(MainActivity.this, new String(responseBody), Toast.LENGTH_SHORT).show();
        }

        // 请求失败时调用此方法
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void post(View view) {
        EditText et_name = (EditText) findViewById(R.id.et_name);
        EditText et_pass = (EditText) findViewById(R.id.et_pass);

        final String name = et_name.getText().toString();
        final String pass = et_pass.getText().toString();

        String url = "http://125.216.240.210:8080/web2/servlet/LoginServlet";
        // 创建异步HttpClient
        // 把要提交的数据封装到RequestParams对象中
        AsyncHttpClient ahc = new AsyncHttpClient();

        // 发送POST请求提交数据
        RequestParams params = new RequestParams();
        params.add("name", name);
        params.add("pass", pass);
        ahc.post(url, params, new MyResponseHandler());

    }
}
