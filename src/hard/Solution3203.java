package hard;

// 3203. Find Minimum Diameter After Merging Two Trees

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3203 {

    private int res;

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int m = edges1.length;
        int n = edges2.length;
        List<Integer>[] g1 = new ArrayList[m + 1];
        List<Integer>[] g2 = new ArrayList[n + 1];
        Arrays.setAll(g1, i -> new ArrayList<>());
        Arrays.setAll(g2, i -> new ArrayList<>());
        for (int[] edge : edges1) {
            g1[edge[0]].add(edge[1]);
            g1[edge[1]].add(edge[0]);
        }
        for (int[] edge : edges2) {
            g2[edge[0]].add(edge[1]);
            g2[edge[1]].add(edge[0]);
        }
        int d1 = diameter(0, -1, g1);
        int d2 = diameter(0, -1, g2);
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }

    // 求数的直径
    private int diameter(int i, int fa, List<Integer>[] g) {
        res = 0;
        dfs(0, -1, g);
        return res;
    }

    private int dfs(int i, int fa, List<Integer>[] g) {

        int maxLen = 0;
        for (int curr : g[i]) {
            if (curr == fa) continue;
            int subLen = dfs(curr, i, g) + 1;
            res = Math.max(res, maxLen + subLen);
            maxLen = Math.max(maxLen, subLen);
        }
        return maxLen;
    }
}
