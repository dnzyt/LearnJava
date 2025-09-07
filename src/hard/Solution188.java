package hard;

// 188. Best Time to Buy and Sell Stock IV

import java.util.Arrays;

public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] memo = new int[n][2][k + 1];
        for (int[][] m : memo) {
            for (int[] row : m) {
                Arrays.fill(row, -1);
            }
        }
        return dfs(n - 1, 0, k, prices, memo);
    }

    private int dfs(int i, int hold, int k, int[] prices, int[][][] memo) {
        if (k < 0) return Integer.MIN_VALUE / 2;
        if (i < 0) return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
        if (memo[i][hold][k] != -1) return memo[i][hold][k];
        int ans = 0;
        if (hold == 1) {
            ans = Math.max(dfs(i - 1, 1, k, prices, memo), dfs(i - 1, 0, k, prices, memo) - prices[i]);
        } else {
            ans = Math.max(dfs(i - 1, 0, k, prices, memo), dfs(i - 1, 1, k - 1, prices, memo) + prices[i]);
        }
        memo[i][hold][k] = ans;
        return ans;
    }

    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        // 0 ~ k都是合法的，一共有k+1种情况
        // 如果用0表示不合法的情况，那么第二维的长度应该是k+2
        int[][][] f = new int[n + 1][k + 2][2];
        for (int[][] m : f) {
            for (int[] row : m) {
                Arrays.fill(row, Integer.MIN_VALUE / 2);
            }
        }
        for (int i = 1; i < k + 2; i++) {
            f[0][i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                f[i + 1][j][0] = Math.max(f[i][j][0], f[i][j][1] + prices[i]);
                f[i + 1][j][1] = Math.max(f[i][j - 1][0] - prices[i], f[i][j][1]);
            }
        }
        return f[n][k + 1][0];
    }

}
