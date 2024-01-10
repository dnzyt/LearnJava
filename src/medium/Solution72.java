package medium;

// 72. Edit Distance

public class Solution72 {
    public int minDistance(String word1, String word2) {
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++)
            dp[i][0] = i;
        for (int j = 1; j <= s2.length; j++)
            dp[0][j] = j;
        for (int i = 1; i <= s1.length; i++)
            for (int j = 1; j <= s2.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (s1[i - 1] == s2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                }
            }
        return dp[s1.length][s2.length];

    }
}
