package hard;

// 3459. Length of Longest V-Shaped Diagonal Segment

import java.util.Arrays;

public class Solution3459 {
    private int[][] grid;
    private int m;
    private int n;
    private int[][][] memo;
    private static final int[][] DIRS = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][10];
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++)
                        res = Math.max(res, dfs(i, j, k, 1, 2));
                }
            }
        return res;
    }

    private int dfs(int i, int j, int k, int turn, int target) {
        int x = DIRS[k][0] + i, y = DIRS[k][1] + j;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != target)
            return 1;
        int mask = k << 1 | turn;
        if (memo[i][j][mask] > 0)
            return memo[i][j][mask];
        int res = dfs(x, y, k, turn, 2 - target);
        if (turn == 1) {
            res = Math.max(res, dfs(x, y, (k + 1) % 4, 0, 2 - target));
        }
        return memo[i][j][mask] = res + 1;
    }
}
