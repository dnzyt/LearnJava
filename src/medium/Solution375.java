package medium;

// 375. Guess Number Higher or Lower II

import java.util.Arrays;

public class Solution375 {
    private int[][] memo;

    public int getMoneyAmount(int n) {
        this.memo = new int[n + 1][n + 1];
        for (int[] row : this.memo)
            Arrays.fill(row, -1);
        return dfs(1, n);
    }

    public int getMoneyAmount2(int n) {
        int[][] f = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            f[i][i + 1] = i;
            for (int j = i + 2; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE / 2;
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i][k - 1], f[k + 1][j]) + k);
                }
            }
        }
        return f[1][n];
    }

    private int dfs(int i, int j) {
        if (i == j) return 0;
        if (i + 1 == j) return i;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MAX_VALUE / 2;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, Math.max(dfs(i, k - 1), dfs(k + 1, j)) + k);
        }
        memo[i][j] = ans;
        return ans;
    }
}
