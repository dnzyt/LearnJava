package medium;

// 714. Best Time to Buy and Sell Stock with Transaction Fee

import java.util.Arrays;

public class Solution714 {
    private int[] prices;
    private int fee;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        int n = prices.length;
        int[][] memo = new int[n][2];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(n - 1, 0, memo);
    }

    private int dfs(int i, int hold, int[][] memo) {
        if (i < 0) return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
        if (memo[i][hold] != -1) return memo[i][hold];
        if (hold == 1) {
            return memo[i][hold] = Math.max(dfs(i - 1, 1, memo), dfs(i - 1, 0, memo) - prices[i] - fee);
        }
        return memo[i][hold] = Math.max(dfs(i - 1, 0, memo), dfs(i - 1, 1, memo) + prices[i]);
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        for (int[] row : f) Arrays.fill(row, Integer.MIN_VALUE / 2);
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
            f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i] - fee);
        }
        return f[n][0];
    }
}
