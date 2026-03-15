package medium;

// 2567. Minimum Score by Changing Two Elements

import java.util.Arrays;

public class Solution2567 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(nums[n - 1] - nums[2], Math.min(nums[n - 2] - nums[1], nums[n - 3] - nums[0]));
    }
}
