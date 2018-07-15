package com.algorithm;

/**
 * 一种计时器的抽象数据类型
 *
 * @author lzy
 * @date 2018-7-15
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
