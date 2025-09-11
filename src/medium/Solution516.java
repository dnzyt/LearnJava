package medium;

// 516. Longest Palindromic Subsequence

import java.util.Arrays;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence2(s, new StringBuilder(s).reverse().toString());
    }

    // 区间dp
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j])
                    f[i][j] = f[i + 1][j - 1] + 2;
                else
                    f[i][j] = Math.max(f[i][j - 1], f[i + 1][j]);
            }
        }
        return f[0][n - 1];
    }

    // f[i][j] = f[i + 1][j - 1] + 2 (s[i] == s[j])
    // f[i][j] = max(f[i + 1][j], f[i][j - 1])   (s[i] != s[j])

    private int longestCommonSubsequence(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int m = a.length;
        int n = b.length;
        int[][] memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(m - 1, n - 1, a, b, memo);
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1, s, t, memo) + 1;
        }
        return memo[i][j] = Math.max(dfs(i - 1, j, s, t, memo), dfs(i, j - 1, s, t, memo));
    }

    private int longestCommonSubsequence2(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        int m = a.length;
        int n = b.length;

        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    f[i + 1][j + 1] = f[i][j] + 1;
                } else {
                    f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i + 1][j]);
                }
            }
        }

        return f[m][n];

    }
}
