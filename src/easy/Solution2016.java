package easy;

// 2016. Maximum Difference Between Increasing Elements

public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int lowest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lowest)
                ans = Math.max(ans, nums[i] - lowest);
            if (lowest > nums[i]) lowest = nums[i];
        }
        return ans;
    }
}
