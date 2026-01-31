package medium;

// 2304. Minimum Path Cost in a Grid

import java.util.Arrays;

public class Solution2304 {
    private int[][] moveCost;
    private int[][] grid;
    private int m;
    private int n;
    private int[][] memo;

    public int minPathCost(int[][] grid, int[][] moveCost) {
        this.moveCost = moveCost;
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dfs(0, j));
        }
        return res;
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return Integer.MAX_VALUE;
        if (i == m - 1)
            return grid[i][j];
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            res = Math.min(res, moveCost[grid[i][j]][k] + dfs(i + 1, k));
        }
        return memo[i][j] = res + grid[i][j];
    }
}
