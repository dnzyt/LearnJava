package medium;

// 3665. Twisted Mirror Path Count

import java.util.Arrays;

public class Solution3665 {
    private int[][] grid;
    private int m;
    private int n;
    private int[][][] memo;
    private static final int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n][2];
        for (int[][] a : memo)
            for (int[] row : a)
                Arrays.fill(row, -1);
        return dfs(m - 1, n - 1, 0);
    }


    // 从(i,j)这个点向dir方向发送有多少种方法
    // right: 0, down: 1
    private int dfs(int i, int j, int dir) {
        if (i < 0 || j < 0)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (memo[i][j][dir] != -1)
            return memo[i][j][dir];
        if (grid[i][j] == 0)
            return memo[i][j][dir] = (dfs(i - 1, j, 1) + dfs(i, j - 1, 0)) % MOD;
        if (dir == 0)
            return memo[i][j][dir] = dfs(i - 1, j, 1) % MOD;
        return memo[i][j][dir] = dfs(i, j - 1, 0) % MOD;
    }
}
