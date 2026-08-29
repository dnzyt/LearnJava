package util;

import java.util.Arrays;

public class LazySegmentTree {

    private static final class Node {
        public int max;
        public int min;
        public int lazy;
    }

    private int n;
    private Node[] tree;

    public LazySegmentTree(int n) {
        this.n = n;
        tree = new Node[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
        Arrays.setAll(tree, i -> new Node());
    }

    public int findFirst(int ql, int qr, int val) {
        return findFirst(1, 0, n - 1, ql, qr, val);
    }

    private int findFirst(int node, int left, int right, int ql, int qr, int val) {
        if (right < ql || left > qr)
            return -1;
        if (tree[node].min > val || tree[node].max < val)
            return -1;
        if (left == right)
            return left;
        pushDown(node);
        int mid = (left + right) >>> 1;
        int idx = findFirst(node * 2, left, mid, ql, qr, val);
        if (idx < 0)
            idx = findFirst(node * 2 + 1, mid + 1, right, ql, qr, val);
        return idx;
    }

    public void update(int ql, int qr, int val) {
        update(1, 0, n - 1, ql, qr, val);
    }

    private void update(int node, int left, int right, int ql, int qr, int val) {
        if (ql <= left && right <= qr) {
            apply(node, val);
            return;
        }
        pushDown(node);
        int mid = (left + right) >>> 1;
        if (ql <= mid)
            update(node * 2, left, mid, ql, qr, val);
        if (qr > mid)
            update(node * 2 + 1, mid + 1, right, ql, qr, val);
        maintain(node);
    }

    private void pushDown(int node) {
        Node curr = tree[node];
        if (curr.lazy == 0)
            return;
        apply(node * 2, curr.lazy);
        apply(node * 2 + 1, curr.lazy);
        curr.lazy = 0;
    }

    private void apply(int node, int val) {
        Node curr = tree[node];
        curr.max += val;
        curr.min += val;
        curr.lazy += val;
    }

    private void maintain(int node) {
        Node curr = tree[node];
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        curr.max = Math.max(left.max, right.max);
        curr.min = Math.min(left.min, right.min);
    }

}
