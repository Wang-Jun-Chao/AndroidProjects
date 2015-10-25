package com.itheima.getsms;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import com.itheima.getsms.domain.Message;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private List<Message> smsList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        smsList = new LinkedList<Message>();
    }

    public void click(View view) {
        // 访问内容提供者
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(Uri.parse("content://sms"), new String[]{"address", "date", "body", "type"},
                null, null, null);

        while (cursor.moveToNext()) {
            String address = cursor.getString(0);
            long date = cursor.getLong(1);
            String body = cursor.getString(2);
            String type = cursor.getString(3);
            System.out.println(address + ":" + date + ":" + body + ":" + type);

            Message sms = new Message(body, type, address, date);
            smsList.add(sms);
        }

        cursor.close();
    }

    public void click2(View view) {
        XmlSerializer xs = Xml.newSerializer();
        File file = new File("/sdcard/sms.xml");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            xs.setOutput(fos, "utf-8");

            xs.startDocument("utf-8", true);
            xs.startTag(null, "message");

            for (Message sms: smsList) {
               xs.startTag(null, "sms");

                xs.startTag(null, "body");
                xs.text(sms.getBody());
                xs.endTag(null, "body");

                xs.startTag(null, "date");
                xs.text(sms.getDate() + "");
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
            xs.endDocument();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
