package medium;

// 3788. Maximum Score of a Split

import java.util.Arrays;

public class Solution3788 {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long sum = Arrays.stream(nums).mapToLong(i -> (long) i).sum();
        long ans = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;
        for (int i = n - 1; i > 0; i--) {
            if (minVal > nums[i])
                minVal = nums[i];
            sum -= nums[i];
            ans = Math.max(ans, sum - minVal);
        }
        return ans;
    }
}
