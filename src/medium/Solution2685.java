package medium;

// 2685. Count the Number of Complete Components

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, i -> new ArrayList<>());

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[2];
            if (!visited[i]) {
                dfs(i, g, visited, count);
                if (count[0] * (count[0] - 1) == count[1])
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int i, List<Integer>[] g, boolean[] visited, int[] count) {
        visited[i] = true;
        count[0]++;
        for (int nxt : g[i]) {
            if (visited[nxt])
                count[1]++;
            else {
                count[1]++;
                dfs(nxt, g, visited, count);
            }
        }
    }
}
