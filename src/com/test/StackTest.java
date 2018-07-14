package com.test;

import com.algorithm.Stack;

/**
 * Stack测试类
 *
 * @author lzy
 * @date 2018-7-14
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> item = new Stack();
        int max = 5;
        for (int i=0;i<max;i++){
            item.push(i);
            System.out.println(item.size());
        }
    }
}
