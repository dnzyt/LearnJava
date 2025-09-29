package medium;

// 1749. Maximum Absolute Sum of Any Subarray

public class Solution1749 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int mx = 0;
        int mn = 0;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
            mx = Math.max(mx, s[i + 1]);
            mn = Math.min(mn, s[i + 1]);
        }
        return Math.abs(mx - mn);
    }
}
