package com.itheima.junit.test;

import android.test.AndroidTestCase;
import com.itheima.junit.utils.Utils;

/**
 * Author: 王俊超
 * Date: 2015-10-04
 * Time: 21:54
 * Declaration: All Rights Reserved !!!
 */
public class TestCase extends AndroidTestCase {
    public void test() {
//        System.out.println("测试框架跑起来了！");

        int result = Utils.add(3, 5);
        // 断言：用来检测实际值与期望值是否一致
        assertEquals(8, result);
    }
}
