package hard;

// 3772. Maximum Subgraph Score in a Tree

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3772 {
    // 换根DP
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int[] subScore = new int[n];
        dfs(g, 0, -1, subScore, good);
        int[] ans = new int[n];

        reroot(g, 0, -1, 0, subScore, ans);
        return ans;
    }

    private int dfs(List<Integer>[] g, int node, int pa, int[] subScore, int[] good) {
        int ans = 0;
        for (int nxt : g[node]) {
            if (nxt == pa)
                continue;
            ans += Math.max(dfs(g, nxt, node, subScore, good), 0);
        }
        subScore[node] = ans + (good[node] == 1 ? 1 : -1);
        return subScore[node];
    }

    private void reroot(List<Integer>[] g, int node, int pa, int paScore, int[] subScore, int[] ans) {
        ans[node] = subScore[node] + Math.max(paScore, 0);
        for (int nxt : g[node]) {
            if (nxt == pa)
                continue;
            reroot(g, nxt, node, ans[node] - Math.max(subScore[nxt], 0), subScore, ans);
        }
    }
}
