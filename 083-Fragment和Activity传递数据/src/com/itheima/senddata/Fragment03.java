package com.itheima.senddata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Author: 王俊超
 * Date: 2015-10-29
 * Time: 08:27
 * Declaration: All Rights Reserved !!!
 */
public class Fragment03 extends Fragment {
    private TextView tv;
    // 返回的view对象会作为fragment02的内容显示在屏幕上

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment03, null);
        tv = (TextView) v.findViewById(R.id.tv);
        return v;
    }

    public void setText(String text) {
        tv.setText(text);
    }
}
