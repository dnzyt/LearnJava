package medium;

// 3689. Maximum Total Subarray Value I

public class Solution3689 {
    public long maxTotalValue(int[] nums, int k) {
        long mx = Long.MIN_VALUE, mn = Long.MAX_VALUE;
        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }
        return (mx - mn) * k;
    }
}
