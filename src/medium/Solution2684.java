package medium;

// 2684. Maximum Number of Moves in a Grid

import java.util.Arrays;

public class Solution2684 {
    private int[][] memo;

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int res = 0;
        for (int i = 0; i < m; i++)
            res = Math.max(res, dfs(i, 0, grid));
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (j == n - 1)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = 0;
        if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1])
            res = dfs(i - 1, j + 1, grid) + 1;
        if (grid[i][j] < grid[i][j + 1])
            res = Math.max(res, dfs(i, j + 1, grid) + 1);
        if (i + 1 < m && grid[i][j] < grid[i + 1][j + 1])
            res = Math.max(res, dfs(i + 1, j + 1, grid) + 1);
        memo[i][j] = res;
        return res;
    }
}
