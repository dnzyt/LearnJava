package medium;

// 583. Delete Operation for Two Strings

public class Solution583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        int l = dfs(m - 1, n - 1, word1.toCharArray(), word2.toCharArray(), memo);
        return m + n - l * 2;
    }

    // 求最长公共子序列
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

    private int dp(String w1, String w2) {
        int m = w1.length();
        int n = w2.length();
        char[] s = w1.toCharArray();
        char[] t = w2.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = s[i] == t[j] ? 1 + f[i][j] : Math.max(f[i][j + 1], f[i + 1][j]);
            }
        }
        return f[m][n];
    }
}
