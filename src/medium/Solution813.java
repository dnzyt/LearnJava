package medium;

// 813. Largest Sum of Averages

public class Solution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n + 1][k + 1];
        double[][] avg = new double[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            double base = 0;
            for (int j = i; j >= 1; j--) {
                base += (double) nums[j - 1];
                avg[j][i] = base / (i - j + 1);
            }
        }

        for (int i = 1; i <= n; i++)
            dp[i][1] = avg[1][i];
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                dp[i][j] = 0;
                for (int t = i; t >= 0; t--) {
                    if (t < j) break;
                    dp[i][j] = Math.max(dp[i][j], dp[t - 1][j - 1] + avg[t][i]);
                }
            }
        }
        return dp[n][k];
    }
}
