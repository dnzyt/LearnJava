package hard;

// 2435. Paths in Matrix Whose Sum Is Divisible by K

import java.util.Arrays;

public class Solution2435 {
    private int[][] grid;
    private int m;
    private int n;
    private int k;
    private int[][][] memo;
    private static final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        this.k = k;

        this.memo = new int[m][n][k];
        for (int[][] a : memo)
            for (int[] row : a)
                Arrays.fill(row, -1);
        return dfs(m - 1, n - 1, 0);
    }

    private int dfs(int i, int j, int v) {
        if (i == 0 && j == 0)
            return (v - grid[0][0]) % k == 0 ? 1 : 0;
        if (i < 0 || j < 0)
            return 0;
        if (memo[i][j][v] != -1)
            return memo[i][j][v];
        int pre = ((v - grid[i][j]) % k + k) % k;
        return memo[i][j][v] = (dfs(i - 1, j, pre) + dfs(i, j - 1, pre)) % MOD;
    }
}
