package medium;

// 1589. Maximum Sum Obtained of Any Permutation

import java.util.Arrays;

public class Solution1589 {
    private static final int MOD = 1_000_000_007;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] diff = new int[n + 1];
        for (int[] req : requests) {
            int left = req[0];
            int right = req[1];
            diff[left] += 1;
            diff[right + 1] -= 1;
        }
        for (int i = 0; i < n; i++)
            diff[i + 1] += diff[i];
        Arrays.sort(diff, 0, n);

        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += (long) nums[i] * diff[i] % MOD;
            ans %= MOD;
        }

        return (int) ans;
    }
}
