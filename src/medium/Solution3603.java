package medium;

// 3603. Minimum Cost Path with Alternating Directions II

import java.util.Arrays;

public class Solution3603 {
    private int[][] waitCost;
    private int m;
    private int n;
    private long[][] memo;

    public long minCost(int m, int n, int[][] waitCost) {
        this.waitCost = waitCost;
        this.m = m;
        this.n = n;
        memo = new long[m][n];
        for (long[] row : memo)
            Arrays.fill(row, -1L);
        return dfs(0, 0) - waitCost[0][0];
    }

    private long dfs(int i, int j) {
        if (i == m - 1 && j == n - 1)
            return (i + 1) * (j + 1);
        if (i < 0 || i >= m || j < 0 || j >= n)
            return Long.MAX_VALUE;
        if (memo[i][j] != -1) return memo[i][j];
        long cost = (i + 1) * (j + 1) + waitCost[i][j];
        return memo[i][j] = cost + Math.min(dfs(i + 1, j), dfs(i, j + 1));

    }

    public long minCost2(int m, int n, int[][] waitCost) {
        long[] f = new long[n];
        Arrays.fill(f, Long.MAX_VALUE);
        f[n - 1] = -waitCost[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i--) {
            f[n - 1] += (i + 1) * n + waitCost[i][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                f[j] = Math.min(f[j + 1], f[j]) + (i + 1) * (j + 1) + waitCost[i][j];
            }
        }
        return f[0] - waitCost[0][0];
    }
}
