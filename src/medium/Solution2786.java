package medium;

// 2786. Visit Array Positions to Maximize Score

import java.util.Arrays;

public class Solution2786 {
    private int[] nums;
    private int x;

    public long maxScore(int[] nums, int x) {
        this.nums = nums;
        this.x = x;
        int n = nums.length;
        long[][] memo = new long[n][2];
        for (long[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE / 2);
        return dfs(0, nums[0] % 2, memo);
    }

    private long dfs(int i, int j, long[][] memo) {
        int n = nums.length;
        if (i == n) return 0;
        if (memo[i][j] != Integer.MIN_VALUE / 2) return memo[i][j];
        if (nums[i] % 2 != j) {
            return memo[i][j] = dfs(i + 1, j, memo);
        }
        return memo[i][j] = Math.max(dfs(i + 1, j, memo), dfs(i + 1, j ^ 1, memo) - x) + nums[i];
    }
}
