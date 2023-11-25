package medium;

// 487. Max Consecutive Ones II

public class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0] == 1 ? 1 : 0;
        dp[0][1] = nums[0] == 0 ? 1 : 0;

        int res = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }
}
