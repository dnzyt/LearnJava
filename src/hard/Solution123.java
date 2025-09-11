package hard;

// 123. Best Time to Buy and Sell Stock III

public class Solution123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n][2][2];
        return dfs(n - 1, 2, 0, prices, memo);
    }

    private int dfs(int i, int j, int hold, int[] prices, int[][][] memo) {
        if (j < 0) return Integer.MIN_VALUE / 2;
        if (i == 0) {
            return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
        }
        if (memo[i][j][hold] != -1) return memo[i][j][hold];
        int ans = 0;
        if (hold == 1) {
            ans = Math.max(dfs(i - 1, j, 1, prices, memo), dfs(i - 1, j, 0, prices, memo) - prices[i]);
        } else {
            ans = Math.max(dfs(i - 1, j, 0, prices, memo), dfs(i - 1, j - 1, 1, prices, memo) + prices[i]);
        }
        memo[i][j][hold] = ans;
        return ans;
    }
}
