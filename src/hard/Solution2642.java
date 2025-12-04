package hard;

// 2642. Design Graph With Shortest Path Calculator

import java.util.Arrays;

public class Solution2642 {

    class Graph {
        private int[][] g;

        public Graph(int n, int[][] edges) {
            g = new int[n][n];
            for (int[] row : g)
                Arrays.fill(row, Integer.MAX_VALUE / 2);
            for (int[] e : edges)
                addEdge(e);
        }

        public void addEdge(int[] edge) {
            g[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            int n = g.length;
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE / 2);
            dist[node1] = 0;
            boolean[] visited = new boolean[n];
            for (; ; ) {
                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && (x == -1 || dist[i] < dist[x]))
                        x = i;
                }
                if (x == -1 || dist[x] == Integer.MAX_VALUE / 2)
                    return -1;
                if (x == node2)
                    return dist[x];
                visited[x] = true;
                for (int i = 0; i < n; i++) {
                    if (dist[x] + g[x][i] < dist[i])
                        dist[i] = dist[x] + g[x][i];
                }
            }
        }
    }

}
