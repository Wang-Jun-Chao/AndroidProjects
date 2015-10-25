package com.itheima.insertcontact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

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
        ContentResolver cr = getContentResolver();
        // 先查询raw_contacts表，获取联系人的主键，然后主键+1，就是要插入的主键id
        Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"),
                new String[]{"contact_id"}, null, null, null);
        int contactId = 1;
        // 如果有联系人
        if (cursorContactId.moveToLast()){
            contactId += cursorContactId.getInt(0);
        }

        ContentValues values = new ContentValues();
        values.put("contact_id", contactId);
        // 把联系人id插入raw_contacts数据库中
        cr.insert(Uri.parse("content://com.android.contacts/raw_contacts"), values);

        values.clear();
        values.put("data1", "二bi");
        values.put("mimetype", "vnd.android.cursor.item/name");
        values.put("raw_contact_id", contactId);
        cr.insert(Uri.parse("content://com.android.contacts/data"), values);

        values.clear();
        values.put("data1", "1344567");
        values.put("mimetype", "vnd.android.cursor.item/phone_v2");
        values.put("raw_contact_id", contactId);
        cr.insert(Uri.parse("content://com.android.contacts/data"), values);

    }
}
