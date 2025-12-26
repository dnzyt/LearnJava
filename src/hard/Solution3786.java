package hard;

// 3786. Total Sum of Interaction Cost in Tree Groups

import java.util.*;

public class Solution3786 {
    private long res;

    public long interactionCosts(int n, int[][] edges, int[] group) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        Map<Integer, Long> total = new HashMap<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++)
            total.merge(group[i], 1L, Long::sum);

        dfs(0, -1, g, total, group);
        return res;
    }

    private Map<Integer, Long> dfs(int node, int fa, List<Integer>[] g, Map<Integer, Long> total, int[] group) {
        Map<Integer, Long> ans = new HashMap<>();
        ans.put(group[node], 1L);
        for (int nxt : g[node]) {
            if (nxt == fa)
                continue;
            Map<Integer, Long> childCount = dfs(nxt, node, g, total, group);
            for (Integer k : total.keySet()) {
                ans.merge(k, childCount.getOrDefault(k, 0L), Long::sum);
            }
        }
        for (Integer k : ans.keySet()) {
            res += ans.get(k) * (total.get(k) - ans.get(k));
        }

        return ans;
    }
}
