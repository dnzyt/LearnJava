package hard;

// 3082. Find the Sum of the Power of All Subsequences

public class Solution3082 {
    private static final int MOD = 1000000007;

    // 贡献法
    // 每个和为k的子序列对结果的贡献2^(nums.length - subSequence.length)
    // 第一个为度为子序列的和，第二个为度为子序列的长度
    // dp[i][s][l] = dp[i-1][s][l] + dp[i-1][s-nums[i]][l-1];
    public int sumOfPower(int[] nums, int k) {
        int l = nums.length;
        int[][] f = new int[k + 1][l + 1];
        f[0][0] = 1;
        for (int i = 1; i <= l; i++) {
            for (int j = k; j >= nums[i - 1]; j--) {
                for (int x = l; x > 0; x--) {
                    f[j][x] += f[j - nums[i - 1]][x - 1];
                    f[j][x] %= MOD;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= l; i++) {
            res += f[k][i] * Math.pow(2, (l - i)) % MOD;
            res %= MOD;
        }
        return res;
    }

    // 每一个元素有三种情况，选，不选但拼接，不选也不拼接
    // f[i][j] 表示前i个元素中以j为标准的能量和
    public int sumOfPower2(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[k + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 0; j--) {
                f[j] = f[j] * 2 % MOD;
                if (j >= nums[i - 1])
                    f[j] = (f[j] + f[j - nums[i - 1]]) % MOD;
            }
        }
        return f[k];
    }
}
