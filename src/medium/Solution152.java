package medium;

// 152. Maximum Product Subarray

public class Solution152 {
    public int maxProduct(int[] nums) {
        int maxVal = nums[0], minVal = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currMax = Math.max(nums[i], Math.max(minVal * nums[i], maxVal * nums[i]));
            int currMin = Math.min(nums[i], Math.min(minVal * nums[i], maxVal * nums[i]));
            maxVal = currMax;
            minVal = currMin;
            res = Math.max(res, maxVal);
        }
        return res;
    }
}
