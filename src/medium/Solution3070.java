package medium;

// 3070. Count Submatrices with Top-Left Element and Sum Less Than k

public class Solution3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = f[i][j + 1] + f[i + 1][j] - f[i][j] + grid[i][j];
                if (f[i + 1][j + 1] <= k)
                    ans++;
            }
        return ans;
    }
}
