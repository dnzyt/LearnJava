package medium;

// 276. Paint Fence

public class Solution276 {

    public int numWays(int n, int k) {
        int[][] dp = new int[n+1][2];
        // 0 - 当前位置与之前不同的颜色
        // 1 - 当前位置与之前相同的颜色
        dp[1][0] = k;
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) * (k - 1);
            dp[i][1] = dp[i-1][0];
        }
        return dp[n][0] + dp[n][1];
    }
}





