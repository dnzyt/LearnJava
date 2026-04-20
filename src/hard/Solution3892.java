package hard;

// 3892. Minimum Operations to Achieve At Least K Peaks

import java.util.Arrays;

public class Solution3892 {

    // 环形打家劫舍
    private int[][] memo;

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int[] s1 = new int[n + 1];
        System.arraycopy(nums, 0, s1, 0, n);
        s1[n] = nums[0];
        int[] s2 = new int[n + 1];
        System.arraycopy(nums, 0, s2, 1, n);
        s2[0] = nums[n - 1];

        memo = new int[n][k + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int ans1 = dfs(n - 1, k, s1);
        for (int[] row : memo)
            Arrays.fill(row, -1);
        int ans2 = dfs(n - 1, k, s2);

        int ans = Math.min(ans1, ans2);
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    private int dfs(int i, int k, int[] nums) {
        if (i <= 0) {
            return k == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if (k == 0)
            return 0;
        if (memo[i][k] != -1)
            return memo[i][k];
        int cost = Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
        return memo[i][k] = Math.min(cost + dfs(i - 2, k - 1, nums), dfs(i - 1, k, nums));
    }
}
