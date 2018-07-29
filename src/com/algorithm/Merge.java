package com.algorithm;

import javax.sound.midi.MidiChannel;

/**
 * 归并排序实现
 *
 * @author lzy
 * @date 2018-7-26
 */
public class Merge {

    private static Comparable[] b;

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k < hi + 1; k++) {
            b[k] = a[k];
        }
        for (int k = lo; k < hi + 1; k++) {

            if (i > mid) {
                a[k] = b[j++];
            } else if (j > hi) {
                a[k] = b[i++];
            } else if (less(b[i], b[j])) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }
    }

    /**
     * 自顶向下和自底向上
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        b = new Comparable[a.length];
        // 自顶向下排序
        sort(a, 0, a.length - 1);

        //自底向上排序
//        for (int i = 1; i < a.length; i++) {
//            for (int lo = 0; lo < a.length - i; lo += i + i) {
//                merge(a, lo, lo + i - 1, Math.min(lo + i + i - 1, a.length - 1));
//            }
//        }
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = (int) (Math.random() * 10 + 1);
        }
        show(a);
        sort(a);
        show(a);
    }

}

