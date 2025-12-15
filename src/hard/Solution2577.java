package hard;

// 2577. Minimum Time to Visit a Cell In a Grid

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2577 {

    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;

        int m = grid.length, n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        dist[0][0] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, 0, 0});
        while (true) {
            int[] curr = q.poll();
            int d = curr[0], x = curr[1], y = curr[2];
            if (x == m - 1 && y == n - 1)
                return d;
            if (d > dist[x][y])
                continue;

            for (int[] dir : DIRS) {
                int newx = x + dir[0], newy = y + dir[1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                    continue;
                int cost = Math.max(d + 1, grid[newx][newy]);
                cost += (cost - newx - newy) % 2;
                if (cost < dist[newx][newy]) {
                    dist[newx][newy] = cost;
                    q.offer(new int[]{cost, newx, newy});
                }
            }
        }
    }
}
