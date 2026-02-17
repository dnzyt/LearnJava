package hard;

// 1449. Form Largest Integer With Digits That Add up to Target

import java.util.*;

public class Solution1449 {
    // 完全背包
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i <= 9; i++) {
            int co = cost[i - 1];
            for (int j = co; j <= target; j++) {
                if (dp[j - co] == null)
                    continue;
                String candidate = Integer.toString(i) + dp[j - co];
                if (dp[j] == null ||
                        dp[j].length() < candidate.length() ||
                        dp[j].length() == candidate.length() && dp[j].compareTo(candidate) < 0)
                    dp[j] = candidate;
            }
        }
        return dp[target] == null ? "0" : dp[target];
    }


    public String largestNumber2(int[] cost, int target) {
        int n = cost.length;
        int[] f = new int[target + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int x : cost) {
            for (int j = x; j <= target; j++)
                f[j] = Math.max(f[j], f[j - x] + 1);
        }

        if (f[target] < 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        int j = target;
        for (int i = n - 1; i >= 0; i--) {
            int x = cost[i];
            while (j >= x && f[j - x] + 1 == f[j]) {
                sb.append(i + 1);
                j -= x;
            }
        }
        return sb.toString();
    }
}
