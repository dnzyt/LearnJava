package medium;

// 3840. House Robber V

import java.util.Arrays;

public class Solution3840 {
    private int[] nums;
    private int[] colors;
    private long[] memo;

    public long rob(int[] nums, int[] colors) {
        this.nums = nums;
        this.colors = colors;

        int n = nums.length;
        this.memo = new long[n];
        Arrays.fill(memo, -1L);
        return dfs(n - 1);
    }

    private long dfs(int i) {
        if (i == 0)
            return nums[0];
        if (i == 1)
            return colors[1] == colors[0] ? Math.max(nums[0], nums[1]) : nums[0] + nums[1];
        if (memo[i] != -1L)
            return memo[i];
        if (colors[i] == colors[i - 1]) {
            return memo[i] = Math.max(dfs(i - 2) + nums[i], dfs(i - 1));
        }
        return memo[i] = dfs(i - 1) + nums[i];
    }
}
