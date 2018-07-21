package com.algorithm;

/**
 * 选择排序实现类
 *
 * @author lzy
 * @date 2018-7-21
 */
public class Selection {

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
        //第一层循环遍历数组a
        for (int i = 0; i < N; i++) {
            int min = i;
            //第二层循环比较a[i]与a[i+1]的大小
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                //找到最小元素之后交换位置
                exch(a, i, min);
            }
        }
    }

}
