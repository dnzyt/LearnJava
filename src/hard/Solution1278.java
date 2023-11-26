package hard;

// 1278. Palindrome Partitioning III

public class Solution1278 {
    // 区间型dp
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        int[][] cost = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (s.charAt(i - 1) == s.charAt(j - 1))
                    cost[j][i] = cost[j + 1][i - 1];
                else
                    cost[j][i] = cost[j + 1][i - 1] + 1;
            }
        }

        for (int i = 1; i <= n; i++)
            dp[i][1] = cost[1][i];

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
                for (int t = i; t >= 1; t--) {
                    if (t < j) break;
                    dp[i][j] = Math.min(dp[i][j], dp[t - 1][j - 1] + cost[t][i]);
                }
            }
        }

        return dp[n][k];
    }

}
