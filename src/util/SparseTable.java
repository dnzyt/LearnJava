package util;

// ST表可以用来维护区间的最大值/最小值，GCD，往右和往上跳的操作(树上倍增)
// 但是建表之后不支持修改操作

public class SparseTable {
    private int[][] st;

    // ST表维护区间最大值
    public SparseTable(int[] arr) {
        int n = arr.length;
        int l = 32 - Integer.numberOfLeadingZeros(n);
        st = new int[n][l];
        // 建表
        for (int i = 0; i < n; i++)
            st[i][0] = arr[i];
        for (int p = 1; p < l; p++) {
            for (int i = 0; i + (1 << p) - 1 < n; i++) {
                st[i][p] = Math.max(st[i][p - 1], st[i + (1 << (p - 1))][p - 1]);
            }
        }
    }

    public int query(int l, int r) {
        int p = 32 - Integer.numberOfLeadingZeros(r - l + 1) - 1;
        return Math.max(st[l][p], st[r - (1 << p) + 1][p]);
    }
}
