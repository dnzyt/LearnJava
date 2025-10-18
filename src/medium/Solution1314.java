package medium;

// 1314. Matrix Block Sum

public class Solution1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] f = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                f[i + 1][j + 1] = f[i][j + 1] + f[i + 1][j] - f[i][j] + mat[i][j];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k), r2 = Math.min(m - 1, i + k);
                int c1 = Math.max(0, j - k), c2 = Math.min(n - 1, j + k);
                ans[i][j] = f[r2 + 1][c2 + 1] - f[r2 + 1][c1] - f[r1][c2 + 1] + f[r1][c1];
            }
        }
        return ans;
    }
}
