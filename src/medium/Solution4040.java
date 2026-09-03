package medium;

// 4040. Minimum Operations to Form Subset Sum I

import java.util.Arrays;

public class Solution4040 {
    private static final int MX = Integer.MAX_VALUE / 2;

    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, MX);
        dp[0] = 0;
        for (int num : nums) {
            for (int j = sum; j > 0; j--) {
                int v = num;
                int cost = 0;
                while (v <= sum && j - v >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - v] + cost);
                    v *= 2;
                    cost++;
                }
                v = num;
                cost = 0;
                while (v > 0 && j - v >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - v] + cost);
                    v /= 2;
                    cost++;
                }
            }
        }
        return dp[sum] == MX ? -1 : dp[sum];
    }
}
