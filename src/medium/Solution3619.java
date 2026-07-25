package medium;

// 3619. Count Islands With Total Value Divisible by K

public class Solution3619 {
    private static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                long sum = dfs(grid, i, j);
                ans += sum % k == 0 ? 1 : 0;
            }
        }
        return ans;
    }

    private long dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        long ans = grid[i][j];
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
                continue;
            ans += dfs(grid, x, y);
        }
        return ans;
    }
}
