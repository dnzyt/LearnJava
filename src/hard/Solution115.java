package hard;

// 115. Distinct Subsequences

import java.util.Arrays;

public class Solution115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        return dp[m][n];
    }

    private char[] a;
    private char[] b;
    private int[][] memo;

    public int numDistinct2(String s, String t) {
        a = s.toCharArray();
        b = t.toCharArray();
        int m = a.length, n = b.length;
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(m - 1, n - 1);
    }

    private int dfs(int i, int j) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        if (a[i] == b[j])
            return memo[i][j] = dfs(i - 1, j - 1) + dfs(i - 1, j);
        return memo[i][j] = dfs(i - 1, j);
    }
}
