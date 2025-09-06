package medium;

// 72. Edit Distance

import java.util.Arrays;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();
        int m = s.length;
        int n = t.length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dfs(m - 1, n - 1, s, t, memo);
    }

    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (memo[i][j] < Integer.MAX_VALUE) return memo[i][j];
        int ans = 0;
        if (s[i] == t[j]) {
            ans = dfs(i - 1, j - 1, s, t, memo);
        } else {
            ans = 1 + Math.min(Math.min(dfs(i - 1, j, s, t, memo), dfs(i, j - 1, s, t, memo)), dfs(i - 1, j - 1, s, t, memo));
        }
        memo[i][j] = ans;
        return ans;
    }

    public int minDistance2(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;

        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            f[i + 1][0] = i + 1;
        for (int j = 0; j < n; j++)
            f[0][j + 1] = j + 1;
        f[0][0] = 0;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                if (w1[i - 1] == w2[j - 1])
                    f[i][j] = f[i - 1][j - 1];
                else
                    f[i][j] = 1 + Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1]));
            }

        return f[m][n];
    }
}
