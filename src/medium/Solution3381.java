package medium;

// 3381. Maximum Subarray Sum With Length Divisible by K

import java.util.Arrays;

public class Solution3381 {
    // 求子数组最大值，除了用Kadane算法，还可以用前缀和
    // 遍历时只要维护此前出现过的最小前缀和就可以
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] remainder = new long[k];
        Arrays.fill(remainder, Long.MAX_VALUE);
        remainder[0] = 0;
        long presum = 0;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            presum += num;
            int r = (i + 1) % k;
            if (remainder[r] != Long.MAX_VALUE)
                res = Math.max(res, presum - remainder[r]);
            remainder[r] = Math.min(remainder[r], presum);
        }
        return res;
    }
}
