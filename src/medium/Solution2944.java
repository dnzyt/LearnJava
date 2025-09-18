package medium;

import java.util.Arrays;

public class Solution2944 {
    private int n;
    private int[] prices;
    private int[] memo;
    public int minimumCoins(int[] prices) {
        this.n = prices.length;
        this.prices = prices;
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return dfs(1);
    }

    private int dfs(int i) {
        if (i > n) return 0;
        if (this.memo[i] != -1) return this.memo[i];
        int ans = Integer.MAX_VALUE;

        for (int j = i + 1; j < i + i + 2; j++) {
            ans = Math.min(ans, dfs(j));
        }
        return this.memo[i] = ans + prices[i - 1];
    }

    // DP
    public int minimumCoins2(int[] prices) {
        int n = prices.length;
        int[] f = new int[n + 1];
        for (int i = n; i > 0; i--) {
            if (i * 2 >= n)
                f[i] = prices[i - 1];
            else {
                int ans = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i * 2 + 1; j++) {
                    ans = Math.min(ans, f[j]);
                }
                f[i] = ans + prices[i - 1];
            }
        }
        return f[1];
    }
}
