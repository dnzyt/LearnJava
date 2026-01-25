package medium;

// 3820. Pythagorean Distance Nodes in a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3820 {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int[] xdist = new int[n];
        int[] ydist = new int[n];
        int[] zdist = new int[n];
        xdist[x] = 0;
        ydist[y] = 0;
        zdist[z] = 0;

        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dfs(g, x, -1, xdist);
        dfs(g, y, -1, ydist);
        dfs(g, z, -1, zdist);

        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[]{xdist[i], ydist[i], zdist[i]};
            Arrays.sort(arr);
            int a = arr[0], b = arr[1], c = arr[2];
            if (a * a + b * b == c * c)
                res++;
        }
        return res;
    }

    private void dfs(List<Integer>[] g, int i, int fa, int[] dist) {
        for (int nxt : g[i]) {
            if (nxt == fa)
                continue;
            dist[nxt] = dist[i] + 1;
            dfs(g, nxt, i, dist);
        }
    }


}
