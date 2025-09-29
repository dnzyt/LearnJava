package medium;

//  3652. Best Time to Buy and Sell Stock using Strategy

public class Solution3652 {
    // 前缀和+分段
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] s1 = new long[n + 1];
        long[] s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s1[i + 1] = s1[i] + prices[i];
            s[i + 1] = s[i] + (long) strategy[i] * prices[i];
        }
        long ans = s[n];
        for (int i = 0; i < n - k + 1; i++) {
            long total = s[i] + 0 + (s1[i + k] - s1[i + k / 2]) + (s[n] - s[i + k]);
            ans = Math.max(ans, total);
        }
        return ans;
    }
}
