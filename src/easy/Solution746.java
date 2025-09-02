package easy;

// 746. Min Cost Climbing Stairs

import java.util.Arrays;

public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(cost.length, cost, memo);
    }

    private int dfs(int i, int[] cost, int[] memo) {
        if (i < 2) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.min(dfs(i - 1, cost, memo) + cost[i - 1], dfs(i - 2, cost, memo) + cost[i - 2]);
        return memo[i];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] f = new int[n + 1];

        for (int i = 2; i <= n; i ++) {
            f[i] = Math.min(f[i - 1] + cost[i - 1], f[i - 2] + cost[i - 2]);
        }
        return f[n];
    }
}
