package medium;

// 198. House Robber

import java.util.Arrays;

public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        int choose = nums[i] + dfs(i + 2, nums, memo);
        int notChoose = dfs(i + 1, nums, memo);
        memo[i] = Math.max(choose, notChoose);
        return memo[i];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        int[] f = new int[n + 2];
        Arrays.fill(f, 0);
        for (int i = 0; i < n; i ++) {
            f[i + 2] = Math.max(f[i + 1], f[i] + nums[i]);
        }
        return f[n + 1];
    }
}
