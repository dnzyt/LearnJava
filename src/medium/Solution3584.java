package medium;

// 3584. Maximum Product of First and Last Elements of a Subsequence

public class Solution3584 {
    // 滑动窗口
    public long maximumProduct(int[] nums, int m) {
        long ans = Long.MIN_VALUE;
        long mx = (long) nums[0], mn = (long) nums[0];
        for (int i = m - 1; i < nums.length; i++) {
            mx = Math.max(mx, nums[i - m + 1]);
            mn = Math.min(mn, nums[i - m + 1]);
            ans = Math.max(ans, Math.max((long) nums[i] * mx, (long) nums[i] * mn));

        }
        return ans;
    }
}
