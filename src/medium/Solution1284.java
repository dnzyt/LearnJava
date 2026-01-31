package medium;

// 1824. Minimum Sideway Jumps

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1284 {
    // 0-1 BFS
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dist = new int[3][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[1][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            int d = dist[i][j];
            if (j == n - 1)
                return d;

            // 同一行看看能不能往前走
            if (obstacles[j + 1] != i + 1 && dist[i][j + 1] > d) {
                dist[i][j + 1] = d;
                q.offerFirst(new int[]{i, j + 1});
            }
            // 看看能不能往上或者下走
            if (obstacles[j] != (i + 1) % 3 + 1 && dist[(i + 1) % 3][j] > d + 1) {
                dist[(i + 1) % 3][j] = d + 1;
                q.offer(new int[]{(i + 1) % 3, j});
            }
            if (obstacles[j] != (i + 2) % 3 + 1 && dist[(i + 2) % 3][j] > d + 1) {
                dist[(i + 2) % 3][j] = d + 1;
                q.offer(new int[]{(i + 2) % 3, j});
            }
        }
        return -1;
    }
}
