package medium;

// 712. Minimum ASCII Delete Sum for Two Strings

public class Solution712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m][n];
        return dfs(m - 1, n - 1, s1.toCharArray(), s2.toCharArray(), memo);
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        if (i < 0 && j < 0) return 0;
        int sum = 0;
        if (i < 0) {
            for (int k = 0; k <= j; k++) sum += t[k];
            return sum;
        }
        if (j < 0) {
            for (int k = 0; k <= i; k++) sum += s[k];
            return sum;
        }
        if (s[i] == t[j]) {
            sum = dfs(i - 1, j - 1, s, t, memo);
        } else {
            sum = Math.min(s[i] + dfs(i - 1, j, s, t, memo), t[j] + dfs(i, j - 1, s, t, memo));
        }
        memo[i][j] = sum;
        return sum;
    }

    private int dp(char[] s, char[] t) {
        int m = s.length;
        int n = t.length;
        int[][] f = new int[m + 1][n + 1];
        int pre = 0;
        for (int i = 0; i < m; i++) {
            f[i + 1][0] = pre + s[i];
            pre += s[i];
        }
        pre = 0;
        for (int j = 0; j < n; j++) {
            f[0][j + 1] = pre + t[j];
            pre += t[j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s[i] == t[j])
                    f[i + 1][j + 1] = f[i][j];
                else
                    f[i + 1][j + 1] = Math.min(s[i] + f[i][j + 1], t[j] + f[i + 1][j]);
            }
        }
        return f[m][n];
    }
}
