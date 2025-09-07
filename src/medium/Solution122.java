package medium;

// 122. Best Time to Buy and Sell Stock II

public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n + 1][2];
        f[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = Math.max(f[i][0], f[i][1] + prices[i]);
            f[i + 1][1] = Math.max(f[i][1], f[i][0] - prices[i]);
        }
        return f[n][0];
    }
}
