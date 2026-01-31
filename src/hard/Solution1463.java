package hard;

// 1463. Cherry Pickup II

import java.util.Arrays;

public class Solution1463 {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] a : dp)
            for (int[] row : a)
                Arrays.fill(row, -1);
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        // i 为行号，j为左边机器人的列位置，k为右边机器人的列位置
        for (int i = 1; i < m; i++) {
            int preRow = i - 1;
            for (int j = 0; j < n - 1; j++)
                for (int k = j + 1; k < n; k++) {
                    int temp = -1;
                    if (j - 1 >= 0) {
                        temp = Math.max(temp, dp[preRow][j - 1][k - 1]);
                        temp = Math.max(temp, dp[preRow][j - 1][k]);
                        if (k + 1 < n)
                            temp = Math.max(temp, dp[preRow][j - 1][k + 1]);
                    }
                    if (k - 1 > j)
                        temp = Math.max(temp, dp[preRow][j][k - 1]);
                    temp = Math.max(temp, dp[preRow][j][k]);
                    if (k + 1 < n)
                        temp = Math.max(temp, dp[preRow][j][k + 1]);
                    if (k - 1 > j + 1)
                        temp = Math.max(temp, dp[preRow][j + 1][k - 1]);
                    if (k > j + 1)
                        temp = Math.max(temp, dp[preRow][j + 1][k]);
                    if (k + 1 < n)
                        temp = Math.max(temp, dp[preRow][j + 1][k + 1]);
                    if (temp == -1)
                        continue;
                    dp[i][j][k] = temp + grid[i][j] + grid[i][k];
                }
        }
        int res = -1;
        for (int[] a : dp[m - 1]) {
            for (int num : a)
                res = Math.max(num, res);
        }
        return res;
    }
}
