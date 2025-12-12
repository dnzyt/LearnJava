package hard;

// 2642. Design Graph With Shortest Path Calculator

import java.util.Arrays;

public class Solution2642 {

    // Dijkstra
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


    // Floyd
    class Graph2 {

        private int[][] dist;
        private int n;

        public Graph2(int n, int[][] edges) {
            int[][] dist = new int[n][n];
            for (int[] row : dist)
                Arrays.fill(row, Integer.MAX_VALUE / 3);
            for (int i = 0; i < n; i++)
                dist[i][i] = 0;

            for (int[] e : edges)
                dist[e[0]][e[1]] = e[2];

            for (int k = 0; k < n; k++)
                for (int i = 0; i < n; i++) {
                    // if (dist[i][k] == Integer.MAX_VALUE / 3)
                    //     continue;
                    for (int j = 0; j < n; j++)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }

            this.dist = dist;
            this.n = n;
        }

        public void addEdge(int[] edge) {
            if (edge[2] >= dist[edge[0]][edge[1]])
                return;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][edge[0]] + edge[2] + dist[edge[1]][j]);
            }
        }

        public int shortestPath(int node1, int node2) {
            return dist[node1][node2] == Integer.MAX_VALUE / 3 ? -1 : dist[node1][node2];
        }
    }
}
