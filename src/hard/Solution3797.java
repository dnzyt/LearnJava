package hard;

// 3797. Count Routes to Climb a Rectangular Grid

import java.util.Arrays;

public class Solution3797 {
    private int m;
    private int n;
    private char[][] grid;
    private int d;
    private static final int MOD = 1000000007;

    public int numberOfRoutes(String[] grid, int d) {
        m = grid.length;
        n = grid[0].length();
        this.d = d;
        this.grid = new char[m][];
        for (int i = 0; i < m; i++)
            this.grid[i] = grid[i].toCharArray();

        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++)
            if (this.grid[0][j] == '.')
                dp[0][j] = 1;

        long[] presum = new long[n + 1];
        for (int j = 0; j < n; j++)
            presum[j + 1] = (presum[j] + dp[0][j]) % MOD;
        for (int j = 0; j < n; j++) {
            if (this.grid[0][j] == '#')
                continue;
            int[] lr = getCurr(0, j);
            dp[0][j] = (presum[lr[1] + 1] - presum[lr[0]]) % MOD;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++)
                presum[j + 1] = (presum[j] + dp[i - 1][j]) % MOD;

            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] == '#')
                    continue;
                int[] lr = getUp(i, j);
                dp[i][j] = ((presum[lr[1] + 1] - presum[lr[0]]) % MOD + MOD) % MOD;
            }
            for (int j = 0; j < n; j++)
                presum[j + 1] = (presum[j] + dp[i][j]) % MOD;

            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] == '#')
                    continue;
                int[] lr = getCurr(i, j);
                dp[i][j] = ((presum[lr[1] + 1] - presum[lr[0]]) % MOD + MOD) % MOD;
            }
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            if (this.grid[m - 1][j] == '#')
                continue;
            ans = (ans + dp[m - 1][j]) % MOD;
        }
        return (int) ans;
    }

    private int[] getCurr(int x, int y) {
        int left = Math.max(0, y - d);
        int right = Math.min(n - 1, y + d);
        return new int[]{left, right};
    }

    private int[] getUp(int x, int y) {
        int left = Math.max(0, y - (int) Math.sqrt((long) d * d - 1));
        int right = Math.min(n - 1, y + (int) Math.sqrt((long) d * d - 1));
        return new int[]{left, right};
    }
}
