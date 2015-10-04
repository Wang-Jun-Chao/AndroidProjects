package com.itheima.other;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.*;

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
        File file = new File("/data/data/com.itheima.permission/files/info3.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br  = new BufferedReader(new InputStreamReader(fis));

            Toast.makeText(this, br.readLine(), Toast.LENGTH_SHORT).show();

            fis.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
