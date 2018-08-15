package com.algorithm;

/**
 * 基于堆的优先队列
 *
 * @author lzy
 * @date 2018-8-15
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N]= v;

    }

    private void swim(int k){
        while (k>1&&less(k/2,k)){
            k = k/2;
        }
    }


    private boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }
}
