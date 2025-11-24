package medium;

// 2492. Minimum Score of a Path Between Two Cities

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2492 {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new List[n + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] r : roads) {
            g[r[0]].add(new int[]{r[1], r[2]});
            g[r[1]].add(new int[]{r[0], r[2]});
        }
        boolean[] visited = new boolean[n + 1];
        return dfs(1, g, visited);
    }

    private int dfs(int i, List<int[]>[] g, boolean[] visited) {
        int ans = Integer.MAX_VALUE;
        visited[i] = true;
        for (int[] nxt : g[i]) {
            int node = nxt[0];
            int dist = nxt[1];
            if (visited[node]) {
                ans = Math.min(ans, dist);
            } else {
                ans = Math.min(ans, dfs(node, g, visited));
            }
        }
        return ans;
    }
}
