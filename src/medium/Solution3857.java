package medium;

// 3857. Minimum Cost to Split into Ones

import java.util.Arrays;

public class Solution3857 {
    private int[] memo;

    public int minCost(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 1)
            return 0;
        if (memo[n] != -1)
            return memo[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, i * (n - i) + dfs(i) + dfs(n - i));
        }
        return memo[n] = ans;
    }

    public int minCost2(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {
                f[i] = Math.min(f[i], j * (i - j) + f[j] + f[i - j]);
            }
        }
        return f[n];
    }
}
