package medium;

// 2327. Number of People Aware of a Secret

public class Solution2327 {
    private static final int MOD = 1000000007;

    // 刷表法
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j < Math.min(n + 1, i + forget); j++)
                f[j] = (f[j] + f[i]) % MOD;
        }
        int ans = 0;
        for (int i = n - forget + 1; i <= n; i++)
            ans = (ans + f[i]) % MOD;
        return ans;
    }

    // 只统计每天刚知道秘密的人
    // 第j天刚知道秘密的人，是第[j-forget, j-delay]这些天刚知道秘密的人贡献的
    // s是知道秘密的人数前缀和
    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        int[] sum = new int[n + 1];
        sum[1] = 1;
        for (int j = 2; j <= n; j++) {
            int know = (sum[Math.max(0, j - delay)] - sum[Math.max(0, j - forget)]) % MOD;
            sum[j] = (sum[j - 1] + know) % MOD;
        }
        return ((sum[n] - sum[Math.max(n - forget, 0)]) % MOD + MOD) % MOD;
    }
}

/*
 * i + delay <= j <= i + forget - 1
 *
 * j - (forget + 1) <= i <= j - delay
 *
 *
 *
 *
 * */
