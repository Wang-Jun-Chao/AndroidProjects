package com.itheima.pullparser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import com.itheima.pullparser.domain.City;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends Activity {
    private List<City> cityList;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 获取src文件夹下的资源文件
        InputStream is = getClassLoader().getResourceAsStream("weather.xml");

        // 拿到Pull解析器对象
        XmlPullParser xp = Xml.newPullParser();
        // 初始化
        try {
            xp.setInput(is, "UTF-8");

            City city = new City();

            // 获取当前结点的事件类型
            // 通过对象当前结点类型的事件进行判断，可以知道当前的节点是什么节点，从而可以判断现在应该做什么
            int type = xp.getEventType();

            while (type != XmlPullParser.END_DOCUMENT) {
                // 根据节点的事件类型进行相关操作
                switch (type) {
                    case XmlPullParser.START_TAG:
                        // 获取当前节点的名称
                        if ("weather".equals(xp.getName())) {
                             // 创建City集合对象，用于存放city的JavaBean
                            cityList = new LinkedList<City>();
                        } else if ("city".equals(xp.getName())){
                            // 创建City的JavaBean对象
                            city = new City();

                        } else if ("name".equals(xp.getName())) {
                            // 获取当前结点的下一个文本结点
                            String name = xp.nextText();
                            city.setName(name);
                        } else if ("temp".equals(xp.getName())) {
                            // 获取当前结点的下一个文本结点
                            String temp = xp.nextText();
                            city.setTemp(temp);
                        }else if ("pm".equals(xp.getName())) {
                            // 获取当前结点的下一个文本结点
                            String pm = xp.nextText();
                            city.setPm(pm);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("city".equals(xp.getName())) {
                            cityList.add(city);
                        }
                        break;
                }

                // 把指针移动到下一下结点，并返回该节点的事件类型
                type = xp.next();
            }


            System.out.println(cityList);

            is.close();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
