package medium;

// 2789. Largest Element in an Array after Merge Operations

public class Solution2789 {
    public long maxArrayValue(int[] nums) {
        long ans = nums[nums.length - 1];
        long temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= temp)
                temp += nums[i];
            else
                temp = nums[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
