package medium;

// 3877. Minimum Removals to Achieve Target XOR

import java.util.Arrays;

public class Solution3877 {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        int mx = 0;
        for (int num : nums)
            mx = Math.max(mx, num);
        int m = 32 - Integer.numberOfLeadingZeros(mx);
        if (m < 32 - Integer.numberOfLeadingZeros(target))
            return -1;
        int[][] f = new int[n + 1][1 << m];
        for (int[] row : f)
            Arrays.fill(row, Integer.MIN_VALUE);
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << m); j++) {
                f[i + 1][j] = Math.max(f[i][j], f[i][j ^ nums[i]] + 1);
            }
        }
        if (f[n][target] < 0)
            return -1;
        return n - f[n][target];
    }
}
