package hard;

// 3553. Minimum Weighted Subgraph With the Required Paths II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3553 {
    private List<int[]>[] g;
    private int[] weights;
    private int[] depth;
    private int[][] stJump;

    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        g = new List[n];
        depth = new int[n];
        weights = new int[n];
        stJump = new int[n][32 - Integer.numberOfLeadingZeros(n)];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        dfs(0, -1, 0, 0);
        int[] ans = new int[queries.length];
        // 如果节点个数大于3，那么应该按照DFN序去走
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1], c = queries[i][2];
            ans[i] = (getDist(a, b) + getDist(b, c) + getDist(c, a)) / 2;
        }
        return ans;
    }

    private int getDist(int a, int b) {
        int lca = getLCA(a, b);
        return weights[a] + weights[b] - 2 * weights[lca];
    }

    private void dfs(int i, int fa, int d, int weight) {
        depth[i] = d;
        stJump[i][0] = fa;
        weights[i] = weight;

        int w = 32 - Integer.numberOfLeadingZeros(d);
        for (int j = 1; j < w; j++) {
            int pa = stJump[i][j - 1];
            if (pa == -1)
                break;
            stJump[i][j] = stJump[pa][j - 1];
        }

        for (int[] nxt : g[i]) {
            if (nxt[0] == fa)
                continue;
            dfs(nxt[0], i, d + 1, weight + nxt[1]);
        }

    }

    private int getKthAncestor(int node, int k) {
        int w = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < w; i++) {
            if (((k >> i) & 1) > 0) {
                node = stJump[node][i];
                if (node == -1)
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
        if (y == x)
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
