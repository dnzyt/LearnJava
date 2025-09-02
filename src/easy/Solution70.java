package easy;

// 70. Climbing Stairs

import java.util.Arrays;

public class Solution70 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        return memo[n];
    }

    public int climbStairs2(int n) {
        int[] f = new int[n + 2];
        Arrays.fill(f, 0);
        f[1] = 1;
        for (int i = 0; i < n; i ++) {
            f[i + 2] = f[i + 1] + f[i];
        }
        return f[n + 1];
    }
}

