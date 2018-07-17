package com.algorithm;

/**
 * union-find算法实现
 *
 * @author lzy
 * @date 2018-7-17
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // 获得p和q的组号
        int pID = find(p);
        int qID = find(q);
        // 如果两个组号相等，直接返回
        if (pID == qID) {
            return;
        }
        // 遍历一次，改变组号使他们属于一个组
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }
}