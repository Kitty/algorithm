package com.algorithm;

/**
 * 低位优先的字符串排序
 *
 * @author lzy
 * @date 2018-9-4
 */
public class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d > 0; d--) {
            int[]count = new int[R+1];
            for (int i=0;i<N;i++){
                count[a[i].charAt(d)+1]++;
            }
        }

    }
}
