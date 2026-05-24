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
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
            }
        return dp[m][n];
    }

    // 区间dp
    public int minInsertions2(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[][] dp = new int[n][n];
        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                if (chs[l] == chs[r])
                    dp[l][r] = dp[l + 1][r - 1];
                else
                    dp[l][r] = Math.min(dp[l + 1][r], dp[l][r - 1]) + 1;
            }
        }
        return dp[0][n - 1];
    }
}


