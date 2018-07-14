package com.algorithm;

import java.util.Iterator;

/**
 * 队列实现下压栈
 *
 * @author lzy
 * @date 2018-7-14
 */
public class Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    int N;

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item deQueue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {

        }

        @Override
        public Item next() {
            Item item =current.item;
            current = current.next;
            return item;
        }
    }
}
