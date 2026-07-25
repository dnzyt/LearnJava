package medium;

// 2812. Find the Safest Path in a Grid

import java.util.*;

public class Solution2812 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int[] pa;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        pa = new int[m * n];
        for (int i = 0; i < m * n; i++)
            pa[i] = i;


        List<Deque<int[]>> groups = new ArrayList<>();
        groups.add(new ArrayDeque<>(q));
        int steps = 1;
        while (!q.isEmpty()) {
            int l = q.size();
            Deque<int[]> temp = new ArrayDeque<>();
            while (l-- > 0) {
                int[] curr = q.poll();
                for (int[] dir : DIRS) {
                    int i = curr[0] + dir[0], j = curr[1] + dir[1];
                    if (i < 0 || i >= m || j < 0 || j >= n || dist[i][j] != -1)
                        continue;
                    dist[i][j] = steps;
                    temp.offer(new int[]{i, j});
                }
            }
            steps++;
            q = new ArrayDeque<>(temp);
            if (!temp.isEmpty())
                groups.add(temp);
        }

        for (int d = groups.size() - 1; d >= 0; d--) {
            Deque<int[]> t = groups.get(d);
            for (int[] h : t) {
                int i = h[0], j = h[1];
                for (int[] dir : DIRS) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n)
                        continue;
                    if (dist[x][y] >= dist[i][j])
                        merge(i * m + j, x * m + y);
                }
            }
            if (find(0) == find((m - 1) * m + (n - 1)))
                return d;
        }

        return 0;
    }

    private int find(int x) {
        if (pa[x] != x)
            pa[x] = find(pa[x]);
        return pa[x];
    }

    private void merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            pa[px] = py;
        }
    }

}
