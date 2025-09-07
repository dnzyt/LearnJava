package medium;

// 1143. Longest Common Subsequence

import java.util.Arrays;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, n - 1, text1.toCharArray(), text2.toCharArray(), memo);
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        if (i < 0 || j < 0) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = 0;
        if (s[i] == t[j]) {
            ans = 1 + dfs(i - 1, j - 1, s, t, memo);
        } else {
            ans = Math.max(dfs(i - 1, j, s, t, memo), dfs(i, j - 1, s, t, memo));
        }
        memo[i][j] = ans;
        return ans;
    }

    public int longestCommonSubsequence2(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int m = s.length();
        int n = t.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (sArr[i - 1] == tArr[j - 1])
                    f[i][j] = 1 + f[i - 1][j - 1];
                else
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[m][n];
    }
}
