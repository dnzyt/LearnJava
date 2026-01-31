package hard;

// 741. Cherry Pickup

import java.util.Arrays;

public class Solution741 {
    private int[][] grid;
    private int n;
    private int[][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new int[n][n][n];
        for (int[][] s : memo)
            for (int[] row : s)
                Arrays.fill(row, Integer.MIN_VALUE);

        return Math.max(0, dfs(n - 1, n - 1, n - 1));
    }

    private int dfs(int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        int res = -1;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0)
            return -1;
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1)
            return -1;
        if (x1 == 0 && y1 == 0)
            return grid[0][0];
        if (memo[x1][y1][x2] != Integer.MIN_VALUE)
            return memo[x1][y1][x2];
        res = Math.max(Math.max(dfs(x1 - 1, y1, x2), dfs(x1, y1 - 1, x2)),
                Math.max(dfs(x1 - 1, y1, x2 - 1), dfs(x1, y1 - 1, x2 - 1)));
        if (res == -1)
            return memo[x1][y1][x2] = -1;
        res += grid[x1][y1];
        if (x1 != x2)
            res += grid[x2][y2];
        return memo[x1][y1][x2] = res;
    }
}
