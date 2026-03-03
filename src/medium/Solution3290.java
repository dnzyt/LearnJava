package medium;

// 3290. Maximum Multiplication Score

public class Solution3290 {
    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[][] f = new long[5][n + 1];
        for (int i = 1; i <= 4; i++)
            f[i][0] = Long.MIN_VALUE / 2;
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= 4; i++) {
                if (j < i) {
                    f[i][j] = Long.MIN_VALUE / 2;
                } else {
                    f[i][j] = Math.max(f[i][j - 1], (long) a[i - 1] * b[j - 1] + f[i - 1][j - 1]);
                }
            }
        }
        return f[4][n];
    }
}
