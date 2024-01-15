package util;

public class FenwickTree {
    // 索引0的位置空出来不用
    public int[] sum;

    public FenwickTree(int n) {
        // 初始值必须都为0
        this.sum = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < sum.length) {
            this.sum[i] += delta;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += this.sum[i];
            i -= lowbit(i);
        }
        return res;
    }

    private int lowbit(int x) {
        return x & (-x);
    }

}
