package hard;

// 2328. Number of Increasing Paths in a Grid

import java.util.Arrays;

public class Solution2328 {
    private int[][] grid;
    private int m;
    private int n;
    private int[][] visited;
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static final int MOD = 1000000007;

    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for (int[] row : visited)
            Arrays.fill(row, -1);
        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res += dfs(i, j);
                res %= MOD;
            }
        return res;
    }

    private int dfs(int i, int j) {
        if (visited[i][j] != -1)
            return visited[i][j];
        int res = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (grid[i][j] < grid[x][y])
                res += dfs(x, y) % MOD;
        }
        return visited[i][j] = (res + 1) % MOD;
    }
}
