package medium;

// 309. Best Time to Buy and Sell Stock with Cooldown

public class Solution309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 2][2];
        f[0][1] = Integer.MIN_VALUE / 2;
        f[1][1] = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            f[i + 2][0] = Math.max(f[i + 1][0], f[i + 1][1] + prices[i]);
            f[i + 2][1] = Math.max(f[i + 1][1], f[i][0] - prices[i]);
        }
        return f[n + 1][0];
    }
}
