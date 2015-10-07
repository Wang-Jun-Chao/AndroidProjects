package com.itheima.xutils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;
import java.io.IOException;

public class MainActivity extends Activity {

    private TextView tv_failure;
    private ProgressBar pb;
    private TextView tv_progress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv_failure = (TextView) findViewById(R.id.tv_failure);
        pb = (ProgressBar) findViewById(R.id.pb);
        tv_progress = (TextView) findViewById(R.id.tv_progress);
    }

    public void click(View view) {
        final String fileName = "NotepadPP.exe";
        // 确定下载地址
        final String path = "http://125.216.240.210:8080/" + fileName;
        HttpUtils utils = new HttpUtils();
        try {
            utils.download(
                    path, // 下载地址
                    Environment.getExternalStorageDirectory().getCanonicalPath() + "/" + fileName,  // 文件保存路径
                    true, // 如果目标文件存在，接着未完成的部分继续下载。服务器不支持RANGE时将从新下载。
                    true, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
                    new RequestCallBack<File>() {

                        @Override
                        public void onSuccess(ResponseInfo<File> responseInfo) {
                            Toast.makeText(MainActivity.this, responseInfo.result.getPath(), Toast.LENGTH_SHORT).show();
                        }


                        @Override
                        public void onFailure(HttpException error, String msg) {
                            tv_failure.setText(msg);
                        }

                        @Override
                        public void onLoading(long total, long current, boolean isUploading) {
                            pb.setMax((int) total);
                            pb.setProgress((int) current);
                            tv_progress.setText(current * 100 / total + "%");
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
