package medium;

// 3979. Maximum Valid Pair Sum

public class Solution3979 {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, mx = 0;
        for (int r = k; r < n; r++) {
            mx = Math.max(mx, nums[r - k]);
            ans = Math.max(ans, mx + nums[r]);
        }
        return ans;
    }
}
