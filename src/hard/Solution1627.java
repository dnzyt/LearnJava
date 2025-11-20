package hard;

// 1627. Graph Connectivity With Threshold

import util.UnionFind;

import java.util.ArrayList;
import java.util.List;

public class Solution1627 {
    private static final int MX = 10000;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n + MX);
        boolean[] isConnected = new boolean[n + 1];
        for (int k = threshold + 1; k <= n; k++) {
            if (isConnected[k]) continue;
            for (int p = k, q = k * 2; q <= n; p += k, q += k) {
                isConnected[q] = true;
                uf.merge(p, q);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (uf.find(q[0]) == uf.find(q[1]))
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}
