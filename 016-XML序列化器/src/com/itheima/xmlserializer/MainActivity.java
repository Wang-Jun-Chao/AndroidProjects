package com.itheima.xmlserializer;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import com.itheima.xmlserializer.domain.Message;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {
    private List<Message> smsList = new LinkedList<Message>();

    /**
     * Called when the activity is first created.
     */
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
        // 使用XML序列化器生成XML文件
        // 1、拿到序列化器对象
        XmlSerializer xs = Xml.newSerializer();
        // 2、初始化
        File file = new File("/sdcard/sms2.xml");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            // encoding:指定用什么编码生成XML文件
            xs.setOutput(fos, "UTF-8");

            // 3、生成XML文件
            // encoding:指定头结点中的encoding属性的值
            xs.startDocument("UTF-8", true);

            xs.startTag(null, "message");

            for (Message sms : smsList) {
                xs.startTag(null, "sms");


                xs.startTag(null, "body");
                xs.text(sms.getBody());
                xs.endTag(null, "body");

                xs.startTag(null, "date");
                xs.text(sms.getDate());
                xs.endTag(null, "date");

                xs.startTag(null, "type");
                xs.text(sms.getType());
                xs.endTag(null, "type");

                xs.startTag(null, "address");
                xs.text(sms.getAddress());
                xs.endTag(null, "address");

                xs.endTag(null, "sms");
            }

            xs.endTag(null, "message");
            // 告诉文档已经结束
            xs.endDocument();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
