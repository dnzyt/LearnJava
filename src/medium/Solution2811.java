package medium;

// 2811. Check if it is Possible to Split Array

import java.util.List;

public class Solution2811 {
    public boolean canSplitArray(List<Integer> nums, int m) {
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        int n = nums.size();
        int[][] memo = new int[n][n];
        return dfs(0, nums.size() - 1, m, sum, nums, memo);
    }

    private boolean dfs(int l, int r, int m, int sum, List<Integer> nums, int[][] memo) {
        if (r - l < 2)
            return true;
        if (memo[l][r] != 0)
            return memo[l][r] > 0;
        boolean ans = false;
        if (sum - nums.get(l) >= m)
            ans |= dfs(l + 1, r, m, sum - nums.get(l), nums, memo);
        if (!ans && sum - nums.get(r) >= m)
            ans = dfs(l, r - 1, m, sum - nums.get(r), nums, memo);
        memo[l][r] = ans ? 1 : -1;
        return ans;
    }

    public boolean canSplitArray2(List<Integer> nums, int m) {
        if (nums.size() <= 2)
            return true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) + nums.get(i + 1) >= m)
                return true;
        }
        return false;
    }
}
