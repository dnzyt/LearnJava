package medium;

// 2101. Detonate the Maximum Bombs

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(bombs[i], bombs[j]))
                    g[i].add(j);
                if (isConnected(bombs[j], bombs[i]))
                    g[j].add(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(g, i, new boolean[n]));
        }
        return ans;
    }

    private boolean isConnected(int[] a, int[] b) {
        long a0 = a[0], a1 = a[1], a2 = a[2];
        long b0 = b[0], b1 = b[1], b2 = b[2];

        long x = (a0 - b0) * (a0 - b0);
        long y = (a1 - b1) * (a1 - b1);
        long r = a2 * a2;
        return x + y <= r;
    }

    private int dfs(List<Integer>[] g, int i, boolean[] visited) {
        visited[i] = true;
        int ans = 1;
        for (int nxt : g[i]) {
            if (!visited[nxt])
                ans += dfs(g, nxt, visited);
        }
        return ans;
    }
}
