package hard;

// 3108. Minimum Cost Walk in Weighted Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3108 {
    // 并查集, 走的路径越多，与的越多，结果越小，所以尽量多走，把同一个连通块里的所有路径都走遍
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] fa = new int[n];
        int[] and = new int[n];
        Arrays.fill(and, -1);
        for (int i = 0; i < n; i++)
            fa[i] = i;

        for (int[] e : edges) {
            int x = find(fa, e[0]);
            int y = find(fa, e[1]);
            and[y] &= e[2];
            if (x != y) {
                and[y] &= and[x];
                fa[x] = y;
            }
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int x = find(fa, query[i][0]);
            int y = find(fa, query[i][1]);
            if (x != y)
                ans[i] = -1;
            else
                ans[i] = and[y];
        }
        return ans;
    }

    private int find(int[] fa, int x) {
        if (x != fa[x]) {
            fa[x] = find(fa, fa[x]);
        }
        return fa[x];
    }


    // DFS
    private int[] minimumCost2(int n, int[][] edges, int[][] query) {
        List<int[]>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        int[] nodeToComp = new int[n];
        List<Integer> comp = new ArrayList<>();
        Arrays.fill(nodeToComp, -1);
        for (int i = 0; i < n; i++) {
            if (nodeToComp[i] == -1)
                comp.add(dfs(i, g, nodeToComp, comp));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];
            if (nodeToComp[s] != nodeToComp[t])
                ans.add(-1);
            else
                ans.add(comp.get(nodeToComp[s]));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int i, List<int[]>[] g, int[] nodeToComp, List<Integer> comp) {
        nodeToComp[i] = comp.size();
        int ans = -1;
        for (int[] e : g[i]) {
            int v = e[0], w = e[1];
            ans &= w;
            if (nodeToComp[v] == -1)
                ans &= dfs(v, g, nodeToComp, comp);
        }
        return ans;

    }

}
