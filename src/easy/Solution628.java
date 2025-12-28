package easy;

// 628. Maximum Product of Three Numbers

import java.util.Arrays;

public class Solution628 {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n - 1] * nums[n - 2] * nums[n - 3];
        ans = Math.max(ans, nums[0] * nums[1] * nums[n - 1]);
        return ans;
    }
}
