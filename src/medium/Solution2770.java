package medium;

// 2770. Maximum Number of Jumps to Reach the Last Index

import java.util.Arrays;

public class Solution2770 {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            long l = (long) nums[i] - target, r = (long) nums[i] + target;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= l && nums[j] <= r && dp[j] != -1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
}
