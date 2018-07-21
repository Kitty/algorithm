package com.test;

import com.algorithm.Selection;

/**
 * 排序算法测试类
 *
 * @author lzy
 * @date 2018-7-21
 */
public class SelectionTest {
    public static void main(String[] args) {
        Comparable[] a = {2, 43, 5, 34, 87, 300, 65, 850,18, 78, 56, 23};
        Selection.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
