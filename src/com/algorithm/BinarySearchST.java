package com.algorithm;

/**
 * 基于数组的二分查找
 *
 * @author lzy
 * @date 2018-7-30
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    /*基于有序数组的二分查找*/
    public int rank(Key key)/*小于key的键的数量*/ {                  /*迭代的二分查找*/
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(Key key, Value val) {                                        /*查找键，找到则更新值，否则创建新的元素*/
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
        if (N == keys.length) {
            resize(2 * keys.length);
        }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key)/*向上取整：大于等于key的最小键*/ {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key)/*向下取整：小于等于key的最大键*/ {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        return keys[i - 1];
    }

    public void delete(Key key)/*从表中删去键key（及其对应的值）*/ {
        if (!contains(key)) {
            return;
        }
        int i = rank(key);
        for (int j = i; j + 1 < N; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        N--;
        if (N > 0 && N == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    public void resize(int max)                /*动态调整数组大小*/ {
        Key[] kt = (Key[]) new Comparable[max];
        Value[] vt = (Value[]) new Comparable[max];
        for (int i = 0; i < N; i++) {
            kt[i] = keys[i];
            vt[i] = vals[i];
        }
        keys = kt;
        vals = vt;
    }

    public boolean contains(Key key)          /*键key是否存在于表中*/ {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return true;
        }
        return false;
    }

    public Iterable<Key> keys(Key lo, Key hi) /*[lo..hi]之间的所有键，已排列*/ {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }
}
