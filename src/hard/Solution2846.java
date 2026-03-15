package hard;

// 2846. Minimum Edge Weight Equilibrium Queries in a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

public class Solution2846 {

    private List<int[]>[] g;
    private int[] depth;
    private int[][] st;
    private int[][] w;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        g = new List[n + 1];
        depth = new int[n + 1];
        int m = 32 - Integer.numberOfLeadingZeros(n);
        st = new int[n + 1][m];
        for (int[] row : st)
            Arrays.fill(row, -1);
        Arrays.setAll(g, i -> new ArrayList<>());
        w = new int[n + 1][26];
        for (int[] e : edges) {
            g[e[0] + 1].add(new int[]{e[1] + 1, e[2] - 1});
            g[e[1] + 1].add(new int[]{e[0] + 1, e[2] - 1});
        }
        dfs(1, 0);
        for (int p = 1; p < m; p++) {
            for (int i = 1; i <= n; i++) {
                if (st[i][p - 1] != -1)
                    st[i][p] = st[st[i][p - 1]][p - 1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] query : queries) {
            int a = query[0] + 1;
            int b = query[1] + 1;
            int lca = lca(a, b);
            int mx = 0;
            for (int i = 0; i < 26; i++) {
                mx = Math.max(mx, w[a][i] + w[b][i] - 2 * w[lca][i]);
            }
            ans.add(depth[a] + depth[b] - depth[lca] * 2 - mx);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int i, int fa) {
        depth[i] = depth[fa] + 1;
        for (int[] nxt : g[i]) {
            if (nxt[0] == fa)
                continue;
            st[nxt[0]][0] = i;
            for (int j = 0; j < 26; j++) {
                w[nxt[0]][j] = w[i][j];
                if (j == nxt[1])
                    w[nxt[0]][j]++;
            }
            dfs(nxt[0], i);
        }
    }

    private int getKthAncestor(int i, int k) {
        int m = Integer.numberOfLeadingZeros(k);
        for (int j = 0; j < m; j++) {
            if (((k >> j) & 1) > 0)
                i = st[i][j];
        }
        return i;
    }

    private int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int t = a;
            a = b;
            b = t;
        }
        b = getKthAncestor(b, depth[b] - depth[a]);
        if (a == b)
            return a;
        int m = 32 - Integer.numberOfLeadingZeros(depth[a] - 1);
        for (int i = m - 1; i >= 0; i--) {
            if (st[a][i] == st[b][i])
                continue;
            a = st[a][i];
            b = st[b][i];
        }
        return st[a][0];
    }
}
