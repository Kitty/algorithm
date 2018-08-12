package com.algorithm;

import java.lang.annotation.ElementType;

/**
 * 基于二叉树的查找
 *
 * @author lzy
 * @date 2018-8-9
 */
public class BST<Key extends Comparable<Key>, Value> {

    //定义树
    private class Node {
        //左结点
        private Node left;
        //右结点
        private Node right;
        private Key key;
        private Value value;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    //根结点
    private Node root;

    //获取树的大小
    public int size() {
        return size(root);
    }

    public int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.N;
    }

    //根据键获取相关联的值
    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node root, Key key) {
        if (root == null) {
            return null;
        }
        //判断被查找键与当前结点键的大小
        int cmp = root.key.compareTo(key);
        //若被查找的键小于当前结点键，则继续在当前结点的左子树上查找
        if (cmp < 0) {
            return get(root.left, key);
        }
        //若被查找的键大于当前结点的键，则继续在当前结点的右子树上查找
        else if (cmp > 0) {
            return get(root.right, key);
        }
        //若相等，则返回相关联的值
        else {
            return root.value;
        }
    }

    //向树中添加键值对，并插入在合适的位置
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node root, Key key, Value value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        //插入的键与当前结点的键进行比较
        int cmp = root.key.compareTo(key);
        //若插入的键小于当前结点的键，则继续向当前结点的左子树中插入
        if (cmp < 0) {
            root.left = put(root.left, key, value);
        }
        //若插入的键大于当前结点的键，则继续向当前结点的右子树中插入
        else if (cmp > 0) {
            root.right = put(root.right, key, value);
        }
        //若查找到相同的键时，则将插入的键相关联的值替换掉当前结点的键相关联的值
        else {
            root.value = value;
        }
        //将树的大小加1
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    //获取树中最小的键
    public Key min() {
        return min(root).key;
    }

    public Node min(Node x) {
        //若当前结点的左子树为空时，则表明当前结点的键是树中最小的键，返回该结点
        if (x.left == null) {
            return x;
        }
        //否则继续向当前结点的左子树查找
        return min(x.left);
    }

    //对给定键进行向下取整
    //如果给定的键小于二叉查找树的根结点的键，
    //那么小于等于key的最大键floor(key)一定在根结点的左子树中；
    //如果给定的键大于二叉查找树的根结点的键，
    //那么只有当根结点右子树中存在小于等于key的结点时，
    //小于等于key的最大键才会出现在右子树中，
    //否则根结点就是小于等于key的最大键。
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    public Node floor(Node root, Key key) {
        if (root == null) {
            return null;
        }
        int cmp = key.compareTo(root.key);
        //如果相等，则返回当前结点
        if (cmp == 0) {
            return root;
        }
        //给定键小于当前结点的键时，继续递归查找当前结点的左子树
        else if (cmp < 0) {
            return floor(root.left, key);
        }
        //给定键大于当前结点的键时，向当前结点的右子树继续遍历，并将结点返回给t
        Node t = floor(root.right, key);
        //若t不为空，则说明右子树中存在小于等于key的最大键，返回t
        if (t != null) {
            return t;
        }
        //否则返回当前结点
        else {
            return root;
        }
    }

    //查找排位为key的键


    public Key select(int key) {
        return select(root, key).key;
    }

    private Node select(Node x, int key) {
        if (x == null) {
            return null;
        }
        int size = size(x.left);
        //如果key小于左子树中的结点数size，那么就继续递归地在左子树中查找排名为k的键
        if (key < size) {
            return select(x.left, key);
        }
        //如果key大于size，我们就递归地在右子树中查找排名为k-t-1的键
        else if (key > size) {
            return select(x.right, key - size - 1);
        }
        //如果size等于key，返回当前根结点中的键
        else {
            return x;
        }
    }

    //根据给定键返回键在树中的排名
    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        //如果给定键小于当前结点的键，则递归地向左子树比较并返回该键在左子树中的排名
        if (cmp < 0) {
            return rank(x.left, key);
        }
        //如果给定键大于当前结点的键，则返回左子树中的结点总数加上1(根结点)再加上右子树中的排名(递归计算)
        else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        }
        //若相等，则返回当前结点左子树中的结点总数
        else {
            return size(x.left);
        }
    }

    //删除最小键
    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        //若当前结点的左子树为空，则返回当前结点的右子树的结点
        if (x.left == null) {
            return x.right;
        }
        //若当前结点的左子树不为空，则继续深入当前结点的左子树直至遇到空左子树
        //进行回溯时将该结点的链接指向该结点的右子树
        x.left = deleteMin(x.left);
        //重新计算树的大小
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    //删除给定键

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        //若给定键小于当前结点的键，则继续深入当前结点的左子树
        if (cmp < 0) {
            x.left = delete(x.left, key);
        }
        //若给定键大于当前结点的键，则继续深入当前结点的右子树
        else if (cmp > 0) {
            x.right = delete(x.right, key);
        }
        //若相等
        else {
            //如果当前结点的左子树为空，则返回当前结点的右子树结点
            if (x.left == null) {
                return x.right;
            }
            //如果当前结点的右子树为空，则返回当前结点的左子树结点
            if (x.right == null) {
                return x.left;
            }
            //否则的话：
            //1.将指向即将被删除的结点的链接保存为t
            Node t = x;
            //2.将x指向它的后继结点min(t.right)
            x = min(t.right);
            //3.将x的右链接(原本指向一棵所有结点都大于x.key的二叉查找树)指向deleteMin(t.right)，也就是在
            //删除后所有的结点仍然都大于x.key的子二叉查找树
            x.right = deleteMin(t.right);
            //4.将x的左链接(本为空)设为t.left(其下所有的键都小于被删除的结点和它的后继结点)
            x.left = t.left;
        }
        //重新计算树的大小
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

}
