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
        item.push(new Integer(1));
        item.push(new Integer(2));
        item.push(new Integer(3));
        item.push(new Integer(4));
        System.out.println("size" + item.size());
        Iterator<Integer> iterator = item.iterator();
        for (int i =0;i<item.size();i++) {
            System.out.println(iterator.next());
        }



    }


}
