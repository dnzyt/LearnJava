package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2290 {

    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.addFirst(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.removeFirst();
            for (int[] dir : DIRS) {
                int x = curr[0] + dir[0], y = curr[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;
                if (dist[curr[0]][curr[1]] + grid[x][y] < dist[x][y]) {
                    dist[x][y] = dist[curr[0]][curr[1]] + grid[x][y];
                    if (grid[x][y] == 0)
                        q.addFirst(new int[]{x, y});
                    else
                        q.addLast(new int[]{x, y});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
