package medium;

// 713. Subarray Product Less Than K

public class Solution713 {
    // 滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int s = 1;
        int left = 0;
        for (int r = 0; r < nums.length; r++) {
            s *= nums[r];
            while (left <= r && s >= k) {
                s /= nums[left];
                left ++;
            }
            ans += r - left + 1;
        }

        return ans;
    }
}
