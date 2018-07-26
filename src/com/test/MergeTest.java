package com.test;

import com.algorithm.Merge;

/**
 * 归并排序测试类
 *
 * @author lzy
 * @date 2018-7-26
 */
public class MergeTest {
    public static void main(String[] args) {
        Comparable[] a = {33, 3, 55, 76, 23, 455, 87, 9, 76, 47,  70};
        Merge.sort(a);
        System.out.println("排序之后");
        for (int i= 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }


}
