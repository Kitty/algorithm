package com.test;

import com.algorithm.QuickSort;

/**
 * 快速排序测试类
 *
 * @author lzy
 * @date 2018-7-28
 */
public class QuickSortTest {
    public static void main(String[] args) {
        Comparable [] a = {1,3,5,4,8,12};
        QuickSort.sort(a);
        QuickSort.show(a);
    }
}
