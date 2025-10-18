package medium;

// 3212. Count Submatrices With Equal Frequency of X and Y

public class Solution3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] x = new int[m][n];
        int[][] y = new int[m][n];
        int[][] fx = new int[m + 1][n + 1];
        int[][] fy = new int[m + 1][n + 1];

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X')
                    x[i][j] = 1;
                else if (grid[i][j] == 'Y')
                    y[i][j] = 1;
                fx[i + 1][j + 1] = fx[i + 1][j] + fx[i][j + 1] - fx[i][j] + x[i][j];
                fy[i + 1][j + 1] = fy[i + 1][j] + fy[i][j + 1] - fy[i][j] + y[i][j];
                if (fx[i + 1][j + 1] == fy[i + 1][j + 1] && fx[i + 1][j + 1] > 0)
                    ans++;
            }
        }
        return ans;
    }
}
