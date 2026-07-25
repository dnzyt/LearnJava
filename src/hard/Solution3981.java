package hard;

// 3981. Count Distinct Ways to Form Target from Two Strings

import java.util.Arrays;

public class Solution3981 {
    private static final int MOD = 1000000007;

    public int interleaveCharacters(String word1, String word2, String target) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        char[] t = target.toCharArray();
        int[][][] memo = new int[w1.length + 1][w2.length + 1][t.length];
        for (int[][] s : memo)
            for (int[] row : s)
                Arrays.fill(row, -1);
        long ans = (long) dfs(w1.length - 1, w2.length - 1, t.length - 1, w1, w2, t, memo) - numDistinct(word1, target) - numDistinct(word2, target);
        return (int) ((ans % MOD + MOD) % MOD);
    }

    private int dfs(int i, int j, int k, char[] w1, char[] w2, char[] t, int[][][] memo) {
        if (i < -1 || j < -1 || i + j + 1 < k)
            return 0;
        if (k < 0)
            return 1;
        if (memo[i + 1][j + 1][k] != -1)
            return memo[i + 1][j + 1][k];
        long res = (long) dfs(i - 1, j, k, w1, w2, t, memo) + dfs(i, j - 1, k, w1, w2, t, memo) - dfs(i - 1, j - 1, k, w1, w2, t, memo);
        if (i >= 0 && w1[i] == t[k])
            res += dfs(i - 1, j, k - 1, w1, w2, t, memo) - dfs(i - 1, j - 1, k - 1, w1, w2, t, memo);
        if (j >= 0 && w2[j] == t[k])
            res += dfs(i, j - 1, k - 1, w1, w2, t, memo) - dfs(i - 1, j - 1, k - 1, w1, w2, t, memo);
        res %= MOD;
        return memo[i + 1][j + 1][k] = (int) res;
    }


    public int numDistinct(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > i)
                    break;
                if (ss[i] == tt[j])
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                else
                    dp[i + 1][j + 1] = dp[i][j + 1];
            }
        }
        return dp[m][n];
    }
}
