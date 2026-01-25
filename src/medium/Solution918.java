package medium;

// 918. Maximum Sum Circular Subarray

public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int sum = 0;
        for (int num : nums)
            sum += num;
        int res = maxSubarray(nums);
        if (res < 0)
            return res;

        return Math.max(res, sum - minSubarray(nums));
    }


    private int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private int minSubarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(0, dp[i - 1]) + nums[i];
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
