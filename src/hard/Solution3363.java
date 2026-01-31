package hard;

// 3363. Find the Maximum Number of Fruits Collected

public class Solution3363 {
    public int maxCollectedFruits(int[][] fruits) {
        int m = fruits.length;
        int n = fruits[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = fruits[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + 1 < n)
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1]);
                if (j - 1 > i + 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1]);
                dp[i][j] += fruits[i][j];
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 1; i > j; i--) {
                dp[i][j] = dp[i][j + 1];
                if (i + 1 < m)
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1]);
                if (i - 1 > j + 1)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1]);
                dp[i][j] += fruits[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++)
            res += fruits[i][i];
        res += dp[n - 1][0] + dp[0][m - 1] - fruits[n - 1][m - 1] * 2;
        return res;
    }
}
