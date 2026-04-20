package medium;

// 3891. Minimum Increase to Maximize Special Indices

import java.util.Arrays;

public class Solution3891 {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for (int i = n - 2; i >= 1; i -= 2)
            suf[i] = suf[i + 2] + Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
        if (n % 2 == 1)
            return suf[1];
        long ans = suf[2];
        long pre = 0l;
        for (int i = 1; i < n - 1; i += 2) {
            pre += Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
            ans = Math.min(ans, pre + suf[i + 3]);
        }
        return ans;
    }

    private int[] nums;
    private long[][] memo;

    public long minIncrease2(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        long ans = 0l;
        for (int i = 1; i < n - 1; i += 2)
            ans += Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
        if (n % 2 == 1)
            return ans;
        memo = new long[n + 1][2];
        for (long[] row : memo)
            Arrays.fill(row, -1l);
        return dfs(n - 2, 1);
    }

    // canSkip : 0 -> no, 1 -> yes
    private long dfs(int i, int canSkip) {
        if (i <= 0)
            return 0;
        long cost = Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
        if (i == 1)
            return canSkip == 0 ? cost : 0;
        if (memo[i][canSkip] != -1l)
            return memo[i][canSkip];
        if (canSkip == 1)
            return memo[i][1] = Math.min(cost + dfs(i - 2, 1), dfs(i - 1, 0));
        return memo[i][0] = dfs(i - 2, 0) + cost;
    }
}
