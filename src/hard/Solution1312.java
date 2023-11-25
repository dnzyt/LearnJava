package hard;

// 1312. Minimum Insertion Steps to Make a String Palindrome

public class Solution1312 {

    // 最长公共子序列问题
    public int minInsertions(String s) {
        int n = s.length();
        String r = new StringBuffer(s).reverse().toString();
        int t = longestCommonSubsequence(s, r);
        return n - t;
    }

    private int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j  -1]);
            }
        return dp[m][n];
    }
}


