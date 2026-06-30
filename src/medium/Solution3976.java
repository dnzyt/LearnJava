package medium;

// 3976. Maximum Subarray Sum After Multiplier

public class Solution3976 {
    private int[] nums;
    private int k;

    public long maxSubarraySum(int[] nums, int k) {
        this.nums = nums;
        this.k = k;

        return Math.max(dfs(true), dfs(false));
    }

    private long dfs(boolean mul) {
        int n = nums.length;
        long[][] f = new long[n + 1][3];
        f[0][0] = f[0][1] = f[0][2] = Long.MIN_VALUE / 2;
        long ans = Long.MIN_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            int y = mul ? nums[i] * k : nums[i] / k;
            f[i + 1][0] = Math.max(f[i][0], 0) + nums[i];
            f[i + 1][1] = Math.max(Math.max(f[i][0], f[i][1]), 0) + y;
            f[i + 1][2] = Math.max(f[i][1], f[i][2]) + nums[i];
            ans = Math.max(f[i + 1][1], f[i + 1][2]);
        }
        return ans;
    }
}
