package hard;

// 1216. Valid Palindrome III

public class Solution1216 {
    // 最长公共子序列问题
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        String r = new StringBuffer(s).reverse().toString();
        int t = longestCommonSubsequence(s, r);
        return n - t <= k;
    }

    private int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <=n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[m][n];
    }

}
