package hard;

// 3225. Maximum Score From Grid Operations

import java.util.Arrays;

public class Solution3225 {
    private long[][] cols;
    private int[][] grid;
    private int n;
    private long[][][] memo;

    public long maximumScore(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        cols = new long[n + 1][n];
        for (int j = 0; j < n; j++)
            cols[1][j] = grid[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cols[i + 1][j] = cols[i][j] + grid[i][j];
            }
        }
        memo = new long[n][n + 1][2];
        for (long[][] s : memo) {
            for (long[] row : s)
                Arrays.fill(row, -1l);
        }
        long ans = 0l;
        for (int curr = 0; curr <= n; curr++) {
            ans = Math.max(ans, dfs(n - 2, curr, false));
        }
        return ans;
    }

    private long dfs(int j, int pre, boolean dec) {
        if (j < 0)
            return 0l;
        if (memo[j][pre][dec ? 1 : 0] != -1l)
            return memo[j][pre][dec ? 1 : 0];
        long ans = 0l;
        for (int curr = 0; curr <= n; curr++) {
            if (curr == pre) {
                ans = Math.max(ans, dfs(j - 1, curr, false));
            } else if (curr < pre) {
                ans = Math.max(ans, dfs(j - 1, curr, true) + cols[pre][j] - cols[curr][j]);
            } else {
                if (dec) {
                    ans = Math.max(ans, dfs(j - 1, curr, false));
                } else {
                    ans = Math.max(ans, dfs(j - 1, curr, false) + cols[curr][j + 1] - cols[pre][j + 1]);
                }
            }
        }

        return memo[j][pre][dec ? 1 : 0] = ans;
    }
}
