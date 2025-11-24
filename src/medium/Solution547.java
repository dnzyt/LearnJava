package medium;

// 547. Number of Provinces

import java.util.ArrayList;
import java.util.Arrays;

public class Solution547 {
    private ArrayList<Integer>[] graph;
    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        graph = new ArrayList[n];
        Arrays.setAll(graph, ArrayList::new);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 0)
                    continue;
                graph[i].add(j);
                graph[j].add(i);
            }
        }

        visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                dfs(i);
            }
        }
        return ans;
    }

    private void dfs(int i) {
        visited[i] = true;
        for (int nxt : graph[i]) {
            if (visited[nxt])
                continue;
            dfs(nxt);
        }
    }
}
