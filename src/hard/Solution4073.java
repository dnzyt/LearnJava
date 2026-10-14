package hard;

// 4073. Count Good Strings

public class Solution4073 {
    private static final int MOD = 1000000007;
    public int countGoodStrings(long n) {
        long[][] f = {{2}, {0}};
        long[][] a = {{1, 1}, {1, 0}};
        long[][] ans = power(a, n - 1, f);
        return (int) ans[0][0];
    }

    private long[][] power(long[][] a, long n, long[][] f) {
        long[][] ans = {{f[0][0]}, {f[1][0]}};
        while (n > 0) {
            if ((n & 1) > 0)
                ans = multiply(a, ans);
            a = multiply(a, a);
            n >>= 1;
        }
        return ans;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int m = a.length, n = b[0].length;
        long[][] ans = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < a[i].length; k++) {
                if (a[i][k] == 0)
                    continue;
                for (int j = 0; j < n; j++)
                    ans[i][j] = (ans[i][j] + a[i][k] * b[k][j]) % MOD;
            }
        }
        return ans;
    }
}
