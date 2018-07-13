package com.test;

import com.algorithm.ResizingArrayStack;

import java.awt.event.ItemEvent;
import java.util.Iterator;

/**
 * 动态调整数组大小测试类
 *
 * @author lzy
 * @date 2018-07-12
 */
public class ResizingArrayStackTest {
    public static void main(String[] args) {
        ResizingArrayStack<Integer> item = new ResizingArrayStack<Integer>();
        Integer a;
        int max = 10;
        //测试ResizingArrayStackT类的push方法
        for (int i = 0; i < max; i++) {
            a = i;
            item.push(a);

            System.out.println(item.size());

        }


    }
}
