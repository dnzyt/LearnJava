package hard;

// 2312. Selling Pieces of Wood

public class Solution2312 {
    public long sellingWood(int m, int n, int[][] prices) {
        int[][] p = new int[m + 1][n + 1];
        for (int[] price : prices) {
            int w = price[0], h = price[1], v = price[2];
            p[w][h] = v;
        }

        long[][] dp = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = p[i][j];
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[m][n];
    }
}
