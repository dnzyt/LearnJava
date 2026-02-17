package util;

public class FenwickTree {
    // 索引0的位置空出来不用
    public int[] tree;

    public FenwickTree(int n) {
        // 初始值必须都为0
        this.tree = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < tree.length) {
            this.tree[i] += delta;
            i += lowbit(i);
        }
    }

    // 求前缀和[1~i]
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += this.tree[i];
            i -= lowbit(i);
        }
        return res;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

}
