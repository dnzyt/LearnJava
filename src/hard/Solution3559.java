package hard;

// 3559. Number of Ways to Assign Edge Weights II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3559 {

    private static boolean initialized;
    private static final int MOD = 1000000007;
    private static int[] pow2;

    private List<Integer>[] g;
    private int[] depth;
    private int[][] stJump;

    public Solution3559() {
        if (initialized)
            return;
        initialized = true;
        pow2 = new int[100000];
        pow2[0] = 1;
        for (int i = 1; i < 100000; i++)
            pow2[i] = pow2[i - 1] * 2 % MOD;

    }

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        g = new List[n + 1];
        depth = new int[n + 1];
        int w = 32 - Integer.numberOfLeadingZeros(n);
        stJump = new int[n + 1][w];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        dfs(1, 0, 0);

        for (int p = 1; p < w; p++) {
            for (int i = 1; i <= n; i++) {
                int pa = stJump[i][p - 1];
                if (pa == 0)
                    stJump[i][p] = 0;
                else
                    stJump[i][p] = stJump[pa][p - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v)
                ans[i] = 0;
            else {
                int lca = getLCA(u, v);
                int du = depth[u] - depth[lca];
                int dv = depth[v] - depth[lca];
                int d = du + dv;
                ans[i] = pow2[d - 1];
            }
        }
        return ans;
    }

    private void dfs(int i, int fa, int d) {
        depth[i] = d;
        stJump[i][0] = fa;
        for (int nxt : g[i]) {
            if (nxt == fa)
                continue;
            dfs(nxt, i, d + 1);
        }
    }

    private int getKthAncestor(int node, int k) {
        int w = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < w; i++) {
            if (((k >> i) & 1) > 0) {
                node = stJump[node][i];
                if (node == 0)
                    break;
            }
        }
        return node;
    }

    private int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (x == y)
            return x;
        int w = 32 - Integer.numberOfLeadingZeros(depth[x]);
        for (int i = w - 1; i >= 0; i--) {
            int px = stJump[x][i], py = stJump[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return stJump[x][0];
    }
}























