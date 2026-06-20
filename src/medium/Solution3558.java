package medium;

// 3558. Number of Ways to Assign Edge Weights I

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3558 {
    private List<Integer>[] g;
    private static int MOD = 1000000007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        long[] x = dfs(1, 0, 0);
        return (int) x[0];
    }

    private long[] dfs(int i, int fa, int depth) {

        long maxD = depth;
        long odd = 1, even = 0;
        for (int nxt : g[i]) {
            if (nxt == fa)
                continue;
            long[] x = dfs(nxt, i, depth + 1); // [odd, even, depth]
            if (x[2] > maxD) {
                odd = (x[0] + x[1]) % MOD;
                even = (x[1] + x[0]) % MOD;
                maxD = x[2];
            }
        }
        return new long[]{odd, even, maxD};
    }
}
