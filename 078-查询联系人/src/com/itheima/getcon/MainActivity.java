package com.itheima.getcon;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.itheima.getcon.domain.Contact;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void click(View view) {
        // 通过内容提供者访问联系人数据
        ContentResolver cr = getContentResolver();
        Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"),
                new String[]{"contact_id"}, null, null, null);

        while (cursorContactId.moveToNext()) {
            String contactId = cursorContactId.getString(0);
            Cursor dataCursor = cr.query(Uri.parse("content://com.android.contacts/data"),
                    new String[]{"data1", "mimetype"},
                    "raw_contact_id=?", new String[]{contactId}, null);

            // 获取所有字段的名字
//            Cursor dataCursor = cr.query(Uri.parse("content://com.android.contacts/data"),
//                    null, "row_contact_id=?", new String[]{contactId}, null);

            Contact contact = new Contact();
            while (dataCursor.moveToNext()) {
                String data1 = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                String mimetype = dataCursor.getString(dataCursor.getColumnIndex("mimetype"));

                // 通过mimetype的判断，把data1设置到正确的字段
                if ("vnd.android.cursor.item/email_v2".equals(mimetype)) {
                    contact.setEmail(data1);
                } else if ("vnd.android.cursor.item/phone_v2".equals(mimetype)) {
                    contact.setPhone(data1);
                } else if ("vnd.android.cursor.item/name".equals(mimetype)) {
                    contact.setName(data1);
                }
            }

            System.out.println(contact);
        }

    }
}
