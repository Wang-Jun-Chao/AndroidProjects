package com.itheima.xiaozhinews;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.itheima.xiaozhinews.domain.News;
import com.loopj.android.image.SmartImageView;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {

    private List<News> newsList;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ListView lv = (ListView) findViewById(R.id.lv);
            // 要保证在设置适配器时，新闻XML文件已经解析完毕了
            lv.setAdapter(new MyAdapter());
        }
    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getNewInfo();


    }

    public class MyAdapter extends BaseAdapter {

        // 获得模型层中元素的数量，用来确定ListView需要有多少个条目
        @Override
        public int getCount() {
            return newsList.size();
        }

        // 返回一个View对象，作为LiewView的条目显示至界面
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            // 另外一种方法
//            if (view != null) {
//                return view;
//            }


            News news = newsList.get(i);
            ViewHolder viewHolder;
            View v;

            // 如果view不为空就直接返回
            if (view == null) {
                v = View.inflate(MainActivity.this, R.layout.item_listview, null);
                // 把布局文件中所有组件的对象封装至ViewHolder中
                viewHolder = new ViewHolder();
                viewHolder.tv_title = (TextView) v.findViewById(R.id.tv_title);
                viewHolder.tv_detail = (TextView) v.findViewById(R.id.tv_detail);
                viewHolder.tv_comment = (TextView) v.findViewById(R.id.tv_comment);
                viewHolder.siv = (SmartImageView) v.findViewById(R.id.iv);

                // 把ViewHolder对象封装至View对象中
                v.setTag(viewHolder);
            } else {
                v = view;
                viewHolder = (ViewHolder) v.getTag();
            }


            // 给三个文本框设置内容
            viewHolder.tv_title.setText(news.getTitle());
            viewHolder.tv_detail.setText(news.getDetail());
            viewHolder.tv_comment.setText(news.getComment() + "条评论");

            // 给新闻图片ImageView设置内容
            viewHolder.siv.setImageUrl(news.getImage());

            return v;
        }

        class ViewHolder {
            TextView tv_title;
            TextView tv_detail;
            TextView tv_comment;
            SmartImageView siv;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }


    }

    public void getNewInfo() {
        Thread t = new Thread() {
            @Override
            public void run() {
                String path = "http://125.216.240.210:8080/news.xml";

                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    // 先建立连接，然后获取响应码
                    if (conn.getResponseCode() == 200) {
                        // 拿到服务器返回的输入流，流里的数据就是HTML文件
                        InputStream is = conn.getInputStream();
                        // 使用PULL解析器解析这个流
                        parseNewsXml(is);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void parseNewsXml(InputStream is) {
        XmlPullParser xp = Xml.newPullParser();
        try {
            xp.setInput(is, "UTF-8");

            // 对节点的事件类型进行判断
            int type = xp.getEventType();
            News news = new News();
            while (type != XmlPullParser.END_DOCUMENT) {
                switch (type) {
                    case XmlPullParser.START_TAG:
                        if ("newslist".equals(xp.getName())) {
                            newsList = new LinkedList<News>();
                        } else if ("news".equals(xp.getName())) {
                            news = new News();
                        } else if ("title".equals(xp.getName())) {
                            String title = xp.nextText();
                            news.setTitle(title);
                        } else if ("detail".equals(xp.getName())) {
                            String detail = xp.nextText();
                            news.setDetail(detail);
                        } else if ("comment".equals(xp.getName())) {
                            String comment = xp.nextText();
                            news.setComment(comment);
                        } else if ("image".equals(xp.getName())) {
                            String image = xp.nextText();
                            news.setImage(image);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("news".equals(xp.getName())) {
                            newsList.add(news);
                        }
                        break;
                }

                // 解析完当前结点后，把指针移动至下一个节点，并返回它的事件类型
                type = xp.next();
            }

            // 发消息，让主线程设置ListView的适配器，如果消息不需要携带数据，可以发送空消息
            handler.sendEmptyMessage(1);

//            System.out.println(newsList);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
