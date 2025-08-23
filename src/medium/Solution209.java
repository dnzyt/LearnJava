package medium;

// 209. Minimum Size Subarray Sum

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int s = 0;
        int ans = nums.length + 1;
        for (int r = 0; r < nums.length; r++) {
            s += nums[r];
            while (s - nums[left] >= target) {
                s -= nums[left];
                left ++;
            }
            if (s >= target) {
                ans = Math.min(ans, r - left + 1);
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }
}
