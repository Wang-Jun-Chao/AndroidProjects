package com.itheima.createxml;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.itheima.createxml.domain.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Message> smsList = new LinkedList<Message>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 虚拟10条短信
        for (int i = 0; i < 10; i++) {
            Message sms = new Message("你好棒！" + i, System.currentTimeMillis() + "", "138" + i + i, i + "");
            smsList.add(sms);
        }
    }

    public void click(View view) {
        // 在内存中把xml备份短信拼接出来
        StringBuilder builder = new StringBuilder(1024);
        builder.append("<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>");
        builder.append("<messages>");
        for (Message sms: smsList) {
            builder.append("<sms>");

            builder.append("<body>");
            builder.append(sms.getBody());
            builder.append("</body>");

            builder.append("<date>");
            builder.append(sms.getDate());
            builder.append("</date>");

            builder.append("<type>");
            builder.append(sms.getType());
            builder.append("</type>");

            builder.append("<address>");
            builder.append(sms.getAddress());
            builder.append("</address>");

            builder.append("</sms>");
        }
        builder.append("</messages>");


        File file = new File("/sdcard/sms.xml");
        try{
            FileWriter writer = new FileWriter(file);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
