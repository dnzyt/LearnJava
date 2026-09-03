package hard;

// 4041. Minimum Operations to Form Subset Sum II

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4041 {
    private static final int MX = Integer.MAX_VALUE / 2;
    public int minOperations(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, MX);
        dp[0] = 0;
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        for (int num : nums) {
            int v = num;
            int divCost = 0;
            Map<Integer, Integer> cost = new HashMap<>();
            if (memo.containsKey(num))
                cost = memo.get(num);
            else {
                while (v > 0) {
                    int multiCost = 0;
                    int x = v;
                    while (x <= sum) {
                        if (cost.containsKey(x))
                            break;

                        cost.put(x, divCost + multiCost);
                        x <<= 1;
                        multiCost++;

                    }
                    v >>= 1;
                    divCost++;
                }
                memo.put(num, cost);
            }
            for (int j = sum; j >= 1; j--) {
                for (int k : cost.keySet()) {
                    if (j - k >= 0)
                        dp[j] = Math.min(dp[j], dp[j - k] + cost.get(k));
                }
            }
            if (dp[sum] == 0)
                return 0;
        }
        return dp[sum] == MX ? -1 : dp[sum];
    }
}
