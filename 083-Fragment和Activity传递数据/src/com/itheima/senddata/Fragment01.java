package com.itheima.senddata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
        Button bt = (Button) v.findViewById(R.id.bt);
        final EditText et = (EditText) v.findViewById(R.id.et_frag);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = et.getText().toString();
                // 把数据传递给activity
                MainActivity ma = (MainActivity) getActivity();
                ma.setText(text);
            }
        });

        return v;
    }
}
