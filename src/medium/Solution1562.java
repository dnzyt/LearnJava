package medium;

// 1562. Find Latest Group of Size M

import util.UnionFind;

public class Solution1562 {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        UnionFind uf = new UnionFind(n);
        int[] s = new int[n];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int x = arr[i] - 1;
            s[x] = 1;
            if (x > 0 && s[x - 1] == 1) {
                if (uf.getSize(uf.find(x - 1)) == m) ans = i;
                uf.merge(x, x - 1);
            }
            if (x < n - 1 && s[x + 1] == 1) {
                if (uf.getSize(uf.find(x + 1)) == m) ans = i;
                uf.merge(x, x + 1);
            }
            if (uf.getSize(uf.find(x)) == m)
                ans = i + 1;
        }
        return ans;
    }
}
