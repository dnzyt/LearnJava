package medium;

// 494. Target Sum

import java.util.Arrays;

public class Solution494 {

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = Arrays.stream(nums).sum();
        if (target + s < 0 || (target + s) % 2 != 0) return 0;
        int cap = (target + s) / 2;

        int[][] memo = new int[n][cap + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(n - 1, cap, nums, memo);
    }

    private int dfs(int i, int capacity, int[] nums, int[][] memo) {
        if (i < 0) {
            return capacity == 0 ? 1 : 0;
        }
        if (memo[i][capacity] != -1) return memo[i][capacity];
        memo[i][capacity] = dfs(i - 1, capacity, nums, memo);
        if (capacity >= nums[i]) {
            memo[i][capacity] += dfs(i - 1, capacity - nums[i], nums, memo);
        }

        return memo[i][capacity];
    }

    // f[i][c] = f[i-1][c-nums[i]] + f[i-1][c]

    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int s = Arrays.stream(nums).sum();
        if (target + s < 0 || (target + s) % 2 != 0) return 0;
        int cap = (target + s) / 2;
        int[][] f = new int[n + 1][cap + 1];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < cap + 1; c++) {
                f[i + 1][c] = f[i][c];
                if (c >= nums[i]) f[i + 1][c] += f[i][c - nums[i]];
            }
        }
        return f[n][cap];
    }
}
