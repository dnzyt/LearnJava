package medium;

// 221. Maximal Square

public class Solution221 {
    // DP解法，f[i][j]的尺寸只和它的左，左上，上有关
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    f[i + 1][j + 1] = 1 + Math.min(Math.min(f[i][j + 1], f[i + 1][j]), f[i][j]);
                } else
                    f[i + 1][j + 1] = 0;
                ans = Math.max(ans, f[i + 1][j + 1]);
            }
        }
        return ans * ans;
    }

    // DP解法的空间优化
    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length, n = matrix.length;
        int[] f = new int[n + 1];
        int pre = 0, ans = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') {
                    int tmp = f[j + 1];
                    f[j + 1] = Math.max(Math.max(pre, f[j]), f[j + 1]) + 1;
                    pre = tmp;
                } else {

                }
                ans = Math.max(ans, f[j + 1]);
            }
        }
        return ans * ans;
    }
}
