package medium;

// 3067. Count Pairs of Connectable Servers in a Weighted Tree Network


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3067 {
    private List<int[]>[] g;
    private List<Integer>[][][] memo;
    private int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        this.signalSpeed = signalSpeed;
        int n = 0;
        for (int[] p : edges)
            n = Math.max(n, Math.max(p[0], p[1]));
        n++;
        g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int divisible = 0;
            for (int[] p : g[i]) {
                int source = p[0];
                int upper = p[1];
                int branch = dfs(i, source, upper);
                ans[i] += divisible * branch;
                divisible += branch;
            }
        }

        return ans;
    }


    private int dfs(int fa, int curr, int upper) {
        int ans = upper % signalSpeed == 0 ? 1 : 0;
        for (int[] p : g[curr]) {
            int nxt = p[0];
            int w = p[1];
            if (nxt == fa) continue;
            ans += dfs(curr, nxt, upper + w);
        }
        return ans;
    }
}
