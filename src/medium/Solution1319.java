package medium;

// 1319. Number of Operations to Make Network Connected

import java.util.ArrayList;
import java.util.List;

public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++)
            g[i] = new ArrayList<Integer>();

        int count = 0;
        for (int[] c : connections) {
            g[c[0]].add(c[1]);
            g[c[1]].add(c[0]);
            count++;
        }

        if (n - 1 > count)
            return -1;

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i, g, visited);
            }
        }
        return ans - 1;
    }

    private void dfs(int i, List<Integer>[] g, boolean[] visited) {
        visited[i] = true;
        for (int nxt : g[i]) {
            if (!visited[nxt])
                dfs(nxt, g, visited);
        }
    }
}
