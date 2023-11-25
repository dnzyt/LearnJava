package hard;

// 727. Minimum Window Subsequence

import java.util.Arrays;

public class Solution727 {
    // 双序列dp
    public String minWindow(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], m + 1);
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= Math.min(i, n); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = dp[i - 1][j] + 1;
            }
        int len = m + 1;
        int idx = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[i][n] < len) {
                len = dp[i][n];
                idx = i;
            }
        }
        if (idx == -1)
            return "";
        return s1.substring(idx - len, idx);


    }
}
