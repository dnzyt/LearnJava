package medium;

// 494. Target Sum

import java.util.Arrays;
import java.util.Collections;

public class Solution494 {
    // sum(A) = (total + target) / 2
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if (target > total || ((total & 1) ^ (target & 1)) == 1)
            return 0;
        return numOfSubsets(nums, (total + target) >> 1);
    }

    // 转换成了01背包问题
    // nums中有多少种选法，可以达成和为target
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
    // 虽然是2维dp，但是可以转换为1维dp
    private int numOfSubsets(int[] nums, int target) {
        if (target < 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1; // 前0个元素种组成和为0的方法有1种
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
