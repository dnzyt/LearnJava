package medium;

// 1155. Number of Dice Rolls With Target Sum

public class Solution1155 {
    private static final int MOD = 1000000007;

    // 初始版本
    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n + 1][target + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int x = j; x <= target; x++) {
                    f[i][x] += f[i - 1][x - j];
                    f[i][x] %= MOD;
                }
            }
        }
        return f[n][target];
    }

    // 滚动数组 + 前缀和
    public int numRollsToTarget2(int n, int k, int target) {
        if (target < n || target > n * k)
            return 0;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int maxJ = Math.min(target, i * k);
            int[] presum = new int[maxJ + 2];
            for (int j = 0; j <= maxJ; j++)
                presum[j + 1] = (presum[j] + f[j]) % MOD;
            for (int j = 0; j <= maxJ; j++) {
                f[j] = ((presum[j] - presum[Math.max(j - k, 0)]) % MOD + MOD) % MOD;
            }
        }
        return f[target];
    }
}

/*
f[x] = f[x-1] + f[x-2] + f[x-3] + .. + f[x-k]


 */