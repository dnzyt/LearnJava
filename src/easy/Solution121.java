package easy;

// 121. Best Time to Buy and Sell Stock

public class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int lowest = prices[0];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, prices[i] - lowest);
            if (lowest > prices[i]) lowest = prices[i];
        }
        return ans;
    }
}
