package medium;

// 63. Unique Paths II

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || f[i - 1] == 0)
                break;
            f[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (f[0] == 0 || obstacleGrid[i][0] == 1)
                f[0] = 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    f[j] = 0;
                else {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[n - 1];
    }
}
