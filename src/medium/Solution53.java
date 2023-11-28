package medium;

// 53. Maximum Subarray

public class Solution53 {

    // 滑动窗口
    public int maxSubArray(int[] nums) {
        int j = 0;
        int total = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            res = Math.max(res, total);
            while (j <= i && total < 0) {
                total -= nums[j];
                j ++;
            }
        }
        return res;
    }

    // DP
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
