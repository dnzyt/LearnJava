package hard;

// 1770. Maximum Score from Performing Multiplication Operations

import java.util.Arrays;

public class Solution1770 {
    private int[] nums;
    private int[] mul;
    private int[][] memo;
    private int n;
    private int m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.mul = multipliers;
        this.m = multipliers.length;
        this.n = nums.length;
        this.memo = new int[m][m];

        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);

        return dfs(0, n - 1);

    }

    private int dfs(int i, int j) {
        int k = n - (j - i + 1);
        if (k == mul.length) return 0;
        if (memo[i][k] != Integer.MIN_VALUE) return memo[i][k];
        return memo[i][k] = Math.max(dfs(i + 1, j) + nums[i] * mul[k], dfs(i, j - 1) + nums[j] * mul[k]);
    }
}
