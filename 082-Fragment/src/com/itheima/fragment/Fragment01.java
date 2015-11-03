package com.itheima.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: 王俊超
 * Date: 2015-10-29
 * Time: 08:27
 * Declaration: All Rights Reserved !!!
 */
public class Fragment01 extends Fragment {
    // 返回的view对象会作为fragment01的内容显示在屏幕上

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment01, null);

        return v;
    }
}
