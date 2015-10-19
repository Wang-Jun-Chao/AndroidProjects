package com.itheima.customcontentprovider;

import android.test.AndroidTestCase;

/**
 * Author: 王俊超
 * Date: 2015-10-19
 * Time: 15:59
 * Declaration: All Rights Reserved !!!
 */
public class Test extends AndroidTestCase {
    public void test() {
        MyOpenHelper helper = new MyOpenHelper(getContext());
        helper.getWritableDatabase();
    }
}
