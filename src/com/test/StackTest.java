package com.test;

import com.algorithm.Stack;

import java.util.Iterator;

/**
 * Stack测试类
 *
 * @author l
 * @date 2018-7-14
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> item = new Stack();
        item.push(1);
        item.push(2);
        item.push(3);
        item.push(4);
        System.out.println("size"+item.size());
        Iterator<Integer> iterator = item.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


}
