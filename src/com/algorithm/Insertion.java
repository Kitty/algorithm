package com.algorithm;

/**
 * 插入算法实现
 *
 * @author lzy
 * @date 2018-7-21
 */
public class Insertion {
    //比较两个数
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    //交换元素位置
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i =0;i<N;i++){
            for (int j =i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
}
