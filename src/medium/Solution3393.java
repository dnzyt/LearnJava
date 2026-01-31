package medium;

// 3393. Count Paths With the Given XOR Value

import java.util.Arrays;

public class Solution3393 {
    private static final int MOD = 1000000007;

    public int countPathsWithXorValue(int[][] grid, int k) {
        int mx = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mx = Math.max(mx, grid[i][j]);
        int u = 1 << (32 - Integer.numberOfLeadingZeros(mx));
        if (k >= u)
            return 0;
        int[][][] memo = new int[m][n][u];
        for (int[][] a : memo)
            for (int[] row : a)
                Arrays.fill(row, -1);
        return dfs(grid, 0, 0, grid[0][0], k, memo);
    }

    private int dfs(int[][] grid, int i, int j, int val, int k, int[][][] memo) {
        if (memo[i][j][val] != -1)
            return memo[i][j][val];
        int m = grid.length, n = grid[0].length;
        if (i == m - 1 && j == n - 1)
            return val == k ? 1 : 0;
        int a = i + 1 < m ? dfs(grid, i + 1, j, val ^ grid[i + 1][j], k, memo) : 0;
        int b = j + 1 < n ? dfs(grid, i, j + 1, val ^ grid[i][j + 1], k, memo) : 0;
        int res = (a + b) % MOD;
        memo[i][j][val] = res;
        return res;
    }
}
