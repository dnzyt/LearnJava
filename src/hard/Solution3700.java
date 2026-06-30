package hard;

// 3700. Number of ZigZag Arrays II

public class Solution3700 {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;
        long[][] t = new long[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k - 1 - i; j++) {
                t[i][j] = 1;
            }
        }
        long[][] f = new long[k][1];
        for (int i = 0; i < k; i++)
            f[i][0] = 1;
        long[][] s = multiply(power(t, n - 1), f);
        long sum = 0;
        for (int i = 0; i < k; i++)
            sum = (sum + s[i][0]) % MOD;
        return (int) (sum * 2 % MOD);
    }

    // 矩阵乘法
    public long[][] multiply(long[][] a, long[][] b) {
        int m = a.length, n = b[0].length;
        int k = a[0].length;
        long[][] ans = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c < k; c++) {
                    ans[i][j] = (ans[i][j] + a[i][c] * b[c][j]) % MOD;
                }
            }
        }
        return ans;
    }

    // 矩阵快速幂
    public long[][] power(long[][] matrix, int p) {
        int m = matrix.length;
        long[][] ans = new long[m][m];
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
