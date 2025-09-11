package medium;

// 2826. Sorting Three Groups

import java.util.Arrays;
import java.util.Collections;
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

    public int minimumOperations2(List<Integer> nums) {
        int n = nums.size();
        int[][] f = new int[n + 1][3];
        for (int[] row : f) Arrays.fill(row, Integer.MIN_VALUE / 2);
        f[0][1] = f[0][2] = f[0][3] = 0;
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            for (int j = 1; j < 4; j++) {
                if (j < num) {
                    f[i + 1][j] = f[i][j];
                } else {
                    f[i + 1][j] = Math.max(f[i][j], f[i][num] + 1);
                }
            }
        }
        return n - f[n][3];
    }

    public int minimumOperations3(List<Integer> nums) {
        int n = nums.size();
        int[] f = new int[4];
        for (int num : nums) {
            int mx = 0;
            for (int i = 1; i < num + 1; i++) {
                mx = Math.max(mx, f[i]);
            }
            f[num] = mx + 1;
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
