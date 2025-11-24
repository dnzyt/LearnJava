package medium;

// 2316. Count Unreachable Pairs of Nodes in an Undirected Graph

import java.util.ArrayList;
import java.util.List;

public class Solution2316 {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                c.add(dfs(i, g, visited));
            }
        }
        long ans = 0;
        long s = 0;
        for (int x : c) {
            ans += s * x;
            s += x;
        }
        return ans;
    }

    private int dfs(int s, List<Integer>[] g, boolean[] visited) {
        int ans = 1;
        for (int nxt : g[s]) {
            if (!visited[nxt]) {
                visited[nxt] = true;
                ans += dfs(nxt, g, visited);
            }
        }
        return ans;
    }
}
