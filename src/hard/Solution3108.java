package hard;

// 3108. Minimum Cost Walk in Weighted Graph

import java.util.Arrays;

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

}
