package medium;

// 797. All Paths From Source to Target

import java.util.ArrayList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(0, graph);
    }

    private List<List<Integer>> dfs(int i, int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        if (i == n - 1) {
            ans.add(new ArrayList<>(List.of(n - 1)));
            return ans;
        }

        for (int nxt : graph[i]) {
            List<List<Integer>> t = dfs(nxt, graph);
            for (List<Integer> x : t)
                x.addFirst(i);
            ans.addAll(t);
        }
        return ans;
    }
}
