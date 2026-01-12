package hard;

// 3117. Minimum Sum of Values by Dividing Array

import java.util.HashMap;
import java.util.Map;

public class Solution3117 {
    private int[] nums;
    private int[] andValues;
    private Map<Long, Integer> memo;

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        this.memo = new HashMap<>();
        int ans = dfs(0, 0, -1);
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    private int dfs(int i, int j, int andVal) {
        int n = nums.length;
        int m = andValues.length;
        if (n - i < m - j)
            return Integer.MAX_VALUE / 2;
        if (j == m)
            return i == n ? 0 : Integer.MAX_VALUE / 2;

        andVal &= nums[i];
        long key = (long) i << 36 | (long) j << 32 | andVal;
        if (memo.containsKey(key))
            return memo.get(key);
        // 可以不用加这一段，记忆话搜索时遇到相同的andVal会自动返回 (logTrick的思想)
//        if (andVal < andValues[j])
//            return Integer.MAX_VALUE / 2;
        int ans = dfs(i + 1, j, andVal);
        if (andVal == andValues[j]) {
            ans = Math.min(ans, nums[i] + dfs(i + 1, j + 1, -1));
        }
        memo.put(key, ans);
        return ans;
    }
}
