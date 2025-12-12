package medium;

import java.util.*;

public class Solution1631 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int[][] RBDIRS = {{1, 0}, {0, 1}};

    // Dijkstra
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0], x = curr[1], y = curr[2];
            if (d > dist[x][y])
                continue;
            for (int[] dir : DIRS) {
                int newx = x + dir[0];
                int newy = y + dir[1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                    continue;
                int cost = Math.abs(heights[x][y] - heights[newx][newy]);
                if (Math.max(d, cost) < dist[newx][newy]) {
                    dist[newx][newy] = Math.max(d, cost);
                    q.offer(new int[]{dist[newx][newy], newx, newy});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    // 并查集
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[] pa = new int[m * n];
        for (int i = 0; i < m * n; i++)
            pa[i] = i;
        TreeMap<Integer, List<int[]>> t = new TreeMap<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                for (int[] dir : RBDIRS) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int d = Math.abs(heights[x][y] - heights[i][j]);
                    if (!t.containsKey(d))
                        t.put(d, new ArrayList<>());
                    t.get(d).add(new int[]{i * n + j, x * n + y});
                }
            }

        for (int d : t.keySet()) {
            for (int[] e : t.get(d)) {
                merge(pa, e[0], e[1]);
                if (find(pa, 0) == find(pa, m * n - 1))
                    return d;
            }
        }
        return 0;
    }

    private int find(int[] pa, int node) {
        if (pa[node] != node)
            pa[node] = find(pa, pa[node]);
        return pa[node];
    }

    private boolean merge(int[] pa, int x, int y) {
        int px = find(pa, x);
        int py = find(pa, y);
        if (px == py)
            return false;
        pa[px] = py;
        return false;
    }
}
