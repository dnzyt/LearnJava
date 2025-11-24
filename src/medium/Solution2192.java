package medium;

// 2192. All Ancestors of a Node in a Directed Acyclic Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges)
            g[e[1]].add(e[0]);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(g, i, visited);
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (visited[j])
                    t.add(j);
            }
            ans.add(t);
        }
        return ans;
    }

    private void dfs(List<Integer>[] g, int i, boolean[] visited) {
        for (int nxt : g[i]) {
            if (!visited[nxt]) {
                visited[nxt] = true;
                dfs(g, nxt, visited);
            }
        }
    }
}
