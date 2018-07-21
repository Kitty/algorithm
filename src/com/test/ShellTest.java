package com.test;

import com.algorithm.Shell;

/**
 * 希尔排序测试类
 *
 * @author lzy
 * @date 2018-7-21
 */
public class ShellTest {
    public static void main(String[] args) {
        Comparable[] a = {2, 43, 5, 34, 87, 300, 65, 850, 18, 78, 56, 23};

        //对数组a进行排序
        Shell.sort(a);
        //打印排序之后的数组
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
