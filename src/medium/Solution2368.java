package medium;

// 2368. Reachable Nodes With Restrictions

import java.util.*;

public class Solution2368 {
    private List<Integer>[] g;
    private Set<Integer> restricted;
    private int ans;


    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        this.restricted = new HashSet<>();
        for (int r : restricted)
            this.restricted.add(r);

        return dfs(0, -1);
    }

    private int dfs(int i, int fa) {
        int res = 1;
        for (int nxt : g[i]) {
            if (nxt == fa || restricted.contains(nxt))
                continue;
            res += dfs(nxt, i);
        }
        return res;
    }
}
