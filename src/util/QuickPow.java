package util;

public class QuickPow {
    public int pow(int x, int y) {
        int res = 1;
        int curr = x;
        while (y > 0) {
            if ((y & 1) == 1)
                res = res * curr;
            curr *= curr;
            y >>= 1;
        }
        return res;
    }

    // 矩阵乘法
    public int[][] multiply(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int k = a[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return ans;
    }

    // 矩阵快速幂
    public int[][] power(int[][] matrix, int p) {
        int m = matrix.length;
        int[][] ans = new int[m][m];
        for (int i = 0; i < m; i++)
            ans[i][i] = 1;
        while (p > 0) {
            if ((p & 1) > 0) {
                ans = multiply(ans, matrix);
            }
            p >>= 1;
            matrix = multiply(matrix, matrix);
        }
        return ans;
    }
}
