package hard;

// 312. Burst Balloons

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution312 {
    public int maxCoins(int[] nums) {
        // 区间型dp 类型2
        // 大区间的最优解依赖于每个小区间的最优解
        // dp[i][j]表示burst从第i个气球到第j个气球可以取得的最大值
        int n = nums.length;
        int[] coins = new int[n + 2];
        IntStream.range(0, n).forEach(i -> coins[i + 1] = nums[i]);
        coins[0] = 1;
        coins[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];  // 0 ~ (n-1)

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], coins[i - 1] * coins[k] * coins[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][n];

    }
}
