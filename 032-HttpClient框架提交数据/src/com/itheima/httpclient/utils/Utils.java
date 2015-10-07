package com.itheima.httpclient.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author: 王俊超
 * Date: 2015-10-07
 * Time: 09:11
 * Declaration: All Rights Reserved !!!
 */
public class Utils {
    public static String getTextFromStream(InputStream is) {
        byte[] b = new byte[1024];
        int len = 0;
        // 创建字节数组输出流，读取输入流的文本数数据时，同步把数据写入到数据输出流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            while ((len = is.read(b)) !=  -1) {
                bos.write(b, 0, len);
            }
            // 把字节数组输出流里的数据转换成字节数组
            return new String(bos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "";
    }
}
