package hard;

// 1000. Minimum Cost to Merge Stones

import java.util.Arrays;

public class Solution1000 {
    private int[] s;
    private int[] presum;
    private int k;
    private int[][] dp;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0)
            return -1;
        this.k = k;
        s = stones;
        presum = new int[n + 1];
        dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + stones[i];
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        int n = s.length;
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            ans = Math.min(ans, dfs(i, m) + dfs(m + 1, j));
        }
        if (((j - i) % (k - 1)) == 0)
            ans += presum[j + 1] - presum[i];
        return dp[i][j] = ans;
    }
}
