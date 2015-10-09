package com.itheima.ipdialer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        EditText et = (EditText) findViewById(R.id.et);
        SharedPreferences sp = getSharedPreferences("ip", MODE_PRIVATE);
        sp.edit().putString("ipNumber", et.getText().toString()).commit();

    }
}
