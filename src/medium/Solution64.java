package medium;

// 64. Minimum Path Sum

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[n];
        f[0] = grid[0][0];
        for (int i = 1; i < n; i++)
            f[i] = f[i - 1] + grid[0][i];
        for (int i = 1; i < m; i++) {
            f[0] += grid[i][0];
            for (int j = 1; j < n; j++)
                f[j] = Math.min(f[j - 1], f[j]) + grid[i][j];
        }
        return f[n - 1];
    }
}
