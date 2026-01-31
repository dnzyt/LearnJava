package hard;

// 3742. Maximum Path Score in a Grid

import java.util.Arrays;

public class Solution3742 {
    private int[][] grid;
    private int m;
    private int n;
    private int[][][] memo;

    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n][k + 1];
        for (int[][] a : memo)
            for (int[] row : a)
                Arrays.fill(row, Integer.MIN_VALUE);

        int res = dfs(0, 0, k);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    private int dfs(int i, int j, int k) {
        if (i >= m || j >= n)
            return -1;
        int gain = grid[i][j];
        int cost = grid[i][j] == 0 ? 0 : 1;
        if (k - cost < 0)
            return -1;

        if (i == m - 1 && j == n - 1)
            return gain;

        if (memo[i][j][k] != Integer.MIN_VALUE)
            return memo[i][j][k];

        int res = Math.max(dfs(i + 1, j, k - cost), dfs(i, j + 1, k - cost));
        return memo[i][j][k] = (res == -1 ? -1 : res + gain);
    }
}
