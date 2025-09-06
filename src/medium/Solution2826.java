package medium;

// 2826. Sorting Three Groups

import java.util.Arrays;
import java.util.List;

public class Solution2826 {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int m = 0;
        int[] c = nums.stream().mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < n; i++) {
            m = Math.max(m, lis(i, c, memo));
        }
        return n - m;
    }

    private int lis(int i, int[] nums, int[] memo) {

        if (memo[i] != -1) return memo[i];
        int ans = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] <= nums[i]) {
                ans = Math.max(ans, lis(j, nums, memo));
            }
        }
        memo[i] = ans + 1;
        return memo[i];
    }
}
