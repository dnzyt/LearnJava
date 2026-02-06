package medium;

// 2915. Length of the Longest Subsequence That Sums to Target

import java.util.Arrays;
import java.util.List;

public class Solution2915 {
    private int[] s;
    private int n;
    private int[][] memo;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        s = nums.stream().mapToInt(Integer::intValue).toArray();
        n = s.length;
        memo = new int[n][target + 1];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return dfs(n - 1, target);
    }

    private int dfs(int i, int target) {
        if (target == 0)
            return 0;
        if (i < 0)
            return -1;
        if (memo[i][target] != Integer.MIN_VALUE)
            return memo[i][target];
        int res = dfs(i - 1, target);
        if (target - s[i] >= 0) {
            int d = dfs(i - 1, target - s[i]);
            if (d != -1)
                res = Math.max(res, d + 1);
        }
        return memo[i][target] = res;
    }

    public int lengthOfLongestSubsequence2(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] f = new int[n + 1][target + 1];
        for (int[] row : f)
            Arrays.fill(row, Integer.MIN_VALUE);
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int curr = nums.get(i - 1);
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j];
                if (curr <= j && f[i - 1][j - curr] != Integer.MIN_VALUE)
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - curr] + 1);
            }
        }
        return f[n][target] == Integer.MIN_VALUE ? -1 : f[n][target];
    }
}
