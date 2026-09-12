package hard;

// 4046. Minimum Cost Path With At Most K Turns

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution4046 {
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int MX = Integer.MAX_VALUE / 2;
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][][] dp = new int[m][n][k + 1][4];
        for (int[][][] s : dp)
            for (int[][] q : s)
                for (int[] row : q)
                    Arrays.fill(row, MX);
        dp[0][0][k][1] = grid[0][0];
        dp[0][0][k][2] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {grid[0][0], 0, 0, k, 1});
        pq.offer(new int[] {grid[0][0], 0, 0, k, 2});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int c = curr[0], x = curr[1], y = curr[2], turn = curr[3], dir = curr[4];
            if (x == m - 1 && y == n - 1)
                return c;
            if (dp[x][y][turn][dir] < c)
                continue;
            for (int i = 0; i < 4; i++) {
                if (turn == 0 && i != dir)
                    continue;
                if (i != dir && i != ((dir + 1) % 4) && i != ((dir - 1 + 4) % 4))
                    continue;
                int newx = x + DIRS[i][0], newy = y + DIRS[i][1];
                if (newx < 0 || newx >= m || newy < 0 || newy >= n)
                    continue;
                int remaining = turn - (dir == i ? 0 : 1);
                if (dp[newx][newy][remaining][i] > c + grid[newx][newy]) {
                    dp[newx][newy][remaining][i] = c + grid[newx][newy];
                    pq.offer(new int[] {c + grid[newx][newy], newx, newy, remaining, i});
                }

            }
        }
        return -1;
    }
}
