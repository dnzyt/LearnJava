package hard;

// 3336. Find the Number of Subsequences With Equal GCD

import java.util.Arrays;

public class Solution3336 {
    private static final int MOD = 1000000007;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int[][][] memo = new int[n][201][201];
        for (int[][] s : memo)
            for (int[] row : s)
                Arrays.fill(row, -1);
        return dfs(n - 1, 0, 0, nums, memo) - 1;
    }

    private int dfs(int i, int s1, int s2, int[] nums, int[][][] memo) {
        if (i == -1)
            return s1 == s2 ? 1 : 0;
        if (memo[i][s1][s2] != -1)
            return memo[i][s1][s2];
        long res = dfs(i - 1, s1, s2, nums, memo);
        res = (res + dfs(i - 1, gcd(s1, nums[i]), s2, nums, memo)) % MOD;
        res = (res + dfs(i - 1, s1, gcd(s2, nums[i]), nums, memo)) % MOD;
        return memo[i][s1][s2] = (int) res;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
