package hard;

// 1377. Frog Position After T Seconds

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1377 {
    private List<Integer>[] g;
    private double ans;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        g[1].add(0);
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        // dfs(1, 0, t, target, 1);
        long prod = dfs2(1, 0, t, target);
        return prod == 0 ? 0 : 1.0 / prod;
    }

    private boolean dfs(int i, int fa, int leftT, int target, long prod) {
        if (i == target && (leftT == 0 || g[i].size() == 1)) {
            ans = 1.0 / prod;
            return true;
        }
        if (i == target || leftT == 0) return false;
        int cnt = g[i].size() - 1;
        for (int nxt : g[i]) {
            if (fa != nxt && dfs(nxt, i, leftT - 1, target, prod * cnt)) {
                return true;
            }
        }
        return false;
    }


    private long dfs2(int x, int fa, int leftT, int target) {
        if (leftT == 0) {
            return x == target ? 1 : 0;
        }
        if (x == target) return g[x].size() == 1 ? 1 : 0;
        int cnt = g[x].size() - 1;
        for (int nxt : g[x]) {
            if (fa != nxt) {
                long prod = dfs2(nxt, x, leftT - 1, target);
                if (prod != 0)
                    return cnt * prod;
            }

        }
        return 0;
    }
}
