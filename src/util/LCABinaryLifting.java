package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 获取两个节点的LCA
public class LCABinaryLifting {
    private List<Integer>[] graph;
    private int[][] pa;
    private int[] depth;

    // n个节点，n-1条边
    public LCABinaryLifting(List<List<Integer>> edges) {
        int n = edges.size() + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n);

        graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        pa = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(pa[i], -1);
        for (List<Integer> e : edges) {
            int u = e.get(0), v = e.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(0, -1);
        for (int i = 1; i < m; i++)
            for (int j = 0; j < n; j++) {
                int ancestorNode = pa[j][i - 1];
                if (ancestorNode != -1)
                    pa[j][i] = pa[ancestorNode][i - 1];
            }

    }

    private void dfs(int i, int fa) {
        pa[i][0] = fa;
        for (int nxt : graph[i]) {
            if (nxt == fa)
                continue;
            depth[nxt] = depth[i] + 1;
            dfs(nxt, i);
        }
    }

    private int getKthAncestor(int x, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) > 0) {
                x = pa[x][i];
                if (x < 0)
                    return -1;
            }
        }
        return x;
    }

    public int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int temp = x;
            x = y;
            y = temp;
        }

        y = getKthAncestor(y, depth[y] - depth[x]);
        if (x == y)
            return x;
        for (int i = pa[0].length - 1; i >= 0; i--) {
            int px = pa[x][i], py = pa[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return pa[x][0];
    }
}
