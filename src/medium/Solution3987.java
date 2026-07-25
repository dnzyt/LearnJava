package medium;

// 3987. Minimum Total Cost to Process All Elements

public class Solution3987 {
    private static final int MOD = 1000000007;

    public int minimumCost(int[] nums, int k) {
        long cost = 1;
        long resources = k;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= resources)
                resources -= nums[i];
            else {
                int n = ((nums[i] - (int) resources) + k - 1) / k;
                ans = (ans + (cost * n + (long) n * (n - 1) / 2)) % MOD;
                cost = (cost + n) % MOD;
                resources = resources + (long) n * k - nums[i];
            }
        }
        return (int) ans;
    }
}
