package medium;

// 3828. Final Element After Subarray Deletions

public class Solution3828 {
    public int finalElement(int[] nums) {
        return Math.max(nums[0], nums[nums.length - 1]);
    }
}
