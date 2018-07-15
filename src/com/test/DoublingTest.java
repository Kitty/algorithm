package com.test;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * 实验程序
 *
 * @author lzy
 * @date 2018-7-15
 */
public class DoublingTest {
    public static double timeTimeTrial(int N) {
        int MAX = 100000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cut = ThreeSum.count(a);
        return timer.elapsedTime();

    }

    public static void main(String[] args) {
        for (int N = 250;true;N += N){
            double time = timeTimeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }
}
