package com.itheima.getsdavail;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        File path = Environment.getExternalStorageDirectory();
        StatFs statFs = new StatFs(path.getPath());
        long blockSize;
        long totalBlocks;
        long availableBlocks;


        // 这里要Android4.3的版本才行
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.JELLY_BEAN_MR2) {
            blockSize = statFs.getBlockSizeLong();
            totalBlocks = statFs.getBlockCountLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        }   else {
             blockSize = statFs.getBlockSize();
             totalBlocks = statFs.getBlockCount();
             availableBlocks = statFs.getAvailableBlocks();
        }

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText( formatSize(availableBlocks * blockSize));
    }

    private String formatSize(long size) {
        return Formatter.formatFileSize(this, size);
    }
}
