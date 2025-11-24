package easy;

// 1971. Find if Path Exists in Graph

import java.util.ArrayList;
import java.util.List;

public class Solution1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        return dfs(source, destination, graph, visited);
    }

    private boolean dfs(int i, int d, List<Integer>[] graph, boolean[] visited) {
        if (i == d)
            return true;
        visited[i] = true;
        for (int nxt : graph[i]) {
            if (!visited[nxt] && dfs(nxt, d, graph, visited))
                return true;
        }
        return false;
    }
}
