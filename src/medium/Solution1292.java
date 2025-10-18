package medium;

// 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

public class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = f[i + 1][j] + f[i][j + 1] - f[i][j] + mat[i][j];
            }
        }

        for (int l = Math.min(m, n); l > 0; l--) {
            for (int i = 0; i <= m - l; i++) {
                for (int j = 0; j <= n - l; j++) {
                    if (f[i + l][j + l] - f[i][j + l] - f[i + l][j] + f[i][j] <= threshold)
                        return l;

                }
            }
        }

        return 0;
    }
}
