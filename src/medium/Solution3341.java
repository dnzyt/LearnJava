package medium;

// 3341. Find Minimum Time to Reach Last Room I

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3341 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int d = curr[0], x = curr[1], y = curr[2];
            if (d > dist[x][y])
                continue;
            for (int[] dir : DIRS) {
                int newx = x + dir[0], newy = y + dir[1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                    continue;
                int cost = Math.max(d, moveTime[newx][newy]);
                if (cost + 1 < dist[newx][newy]) {
                    dist[newx][newy] = cost + 1;
                    q.offer(new int[]{dist[newx][newy], newx, newy});
                }

            }
        }
        return dist[m - 1][n - 1];
    }
}
