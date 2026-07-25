package medium;

// 3286. Find a Safe Walk Through a Grid

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution3286 {

    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = grid.get(i).get(j);

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);
        Deque<int[]> q = new ArrayDeque<>();
        dist[0][0] = health - g[0][0];
        q.offer(new int[]{0, 0, dist[0][0]});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1], remain = curr[2];
            if (i == m - 1 && j == n - 1 && remain > 0)
                return true;

            for (int[] dir : DIRS) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || remain - g[x][y] <= 0 || remain - g[x][y] <= dist[x][y])
                    continue;
                if (g[x][y] == 0) {
                    dist[x][y] = remain;
                    q.offerFirst(new int[]{x, y, remain});
                } else {
                    dist[x][y] = remain - 1;
                    q.offer(new int[]{x, y, remain - 1});
                }
            }
        }

        return false;
    }

}
