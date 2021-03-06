package com.itheiam.multithreaddownload;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: 王俊超
 * Date: 2015-10-07
 * Time: 10:58
 * Declaration: All Rights Reserved !!!
 */
public class MultiDownload {
    private static int threadCount = 3;
    private static AtomicInteger finishedThread = new AtomicInteger(0);
    // 确定下载地址
    private static final String path = "http://125.216.240.210:8080/QQPlayer.exe";

    public static void main(String[] args) {


        // 发送GET请求，请求这个地址的资源
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            if (conn.getResponseCode() == 200) {
                // 拿到所请求的资源文件的长度
                int length = conn.getContentLength();
                System.out.println(length);

                File file = new File("QQPlayer.exe");
                // 生成临时文件
                RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                // 设置临时文件的大小
                raf.setLength(length);

                raf.close();

                // 计算出每个线程应该下载多少个字节
                int size = length / threadCount;

                for (int i = 0; i < threadCount; i++) {
                    int startIndex = i * size;
                    int endIndex = (i + 1) * size - 1;
                    // 如果是最后一个线程，那么就下载到最后一个位置
                    if (i == threadCount - 1) {
                        endIndex = length - 1;
                    }

//                    System.out.println("线程" + i + ": [" + startIndex + ", " + endIndex + "]");
                    new DownLoadThread(startIndex, endIndex, i).start();
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class DownLoadThread extends Thread {
        private int startIndex;
        private int endIndex;
        private int threadId;

        public DownLoadThread(int startIndex, int endIndex, int threadId) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            // 再次发送HTTP请求，，下载原文件
            try {

                // 生成一个专门用来记录下载进度的临时文件
                File progressFile = new File(threadId + ".txt");
                // 判断文本临时文件是否存在
                if (progressFile.exists()) {
                    FileInputStream fis = new FileInputStream(progressFile);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    // 从进度临时文件中读取出上一次下载的总进度，然后与原本的下载位置相加，得到新的开始位置
                    startIndex += Integer.parseInt(br.readLine());
                    fis.close();
                    br.close();

                }

                System.out.println("真实的线程" + threadId + ": [" + startIndex + ", " + endIndex + "]");

                URL url = new URL(path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);
                conn.setRequestProperty("Range", "bytes=" + startIndex + "-" + endIndex);
                // 请求部分部分数据，响应码是206
                if (conn.getResponseCode() == 206) {
                    // 此时流里只有1/3原文件的数据
                    InputStream is = conn.getInputStream();
                    byte[] buffer = new byte[4096];
                    int len = 0;

                    int total = 0;

                    // 拿到临时文件的引用
                    File file = new File("QQPlayer.exe");
                    RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                    // 把文件的写入位置移动到startIndex
                    raf.seek(startIndex);
                    while ((len = is.read(buffer)) != -1) {
                        total += len;
                        // 每次读取流里的数据，同步把数据写入文件
                        raf.write(buffer, 0, len);


                        RandomAccessFile progressRaf = new RandomAccessFile(progressFile, "rwd");
                        // 每次读取流里的数据之后，同步把当前线程下载的总总进度写入临时文件中
                        progressRaf.write((total + "").getBytes());
                        progressRaf.close();
                    }
                    raf.close();
//                    progressFile.delete();
                    //
                    finishedThread.incrementAndGet();
                    synchronized (path) {
                        if (finishedThread.get() == threadCount) {
                            finishedThread.set(0);
                            for (int i = 0; i < threadCount; i++) {
                                File f = new File(i + ".txt");
                                f.delete();
                            }
                        }
                    }

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
