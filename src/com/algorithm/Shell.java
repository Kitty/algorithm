package com.algorithm;

import sun.rmi.server.InactiveGroupException;

/**
 * 希尔排序算法实现
 *
 * @author lzy
 * @date 2018-7-21
 */
public class Shell {
    //比较两个数
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j-= h) {
                    exch(a, j, j - h);
                }

            }
            h = h / 3;
        }
    }

}
