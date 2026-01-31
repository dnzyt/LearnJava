package hard;

// 1937. Maximum Number of Points with Cost

import java.util.Arrays;

public class Solution1937 {
//    private int[][] points;
//    private int m;
//    private int n;
//    private long[][] memo;

    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = points[0][j];
        for (int i = 1; i < m; i++) {
            long preMax = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                preMax = Math.max(dp[i - 1][j] + j, preMax);
                dp[i][j] = preMax + (points[i][j] - j);
            }
            long suffixMax = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                suffixMax = Math.max(dp[i - 1][j] - j, suffixMax);
                dp[i][j] = Math.max(dp[i][j], suffixMax + (points[i][j] + j));
            }
        }
        long res = Long.MIN_VALUE;
        for (long num : dp[m - 1])
            res = Math.max(res, num);
        return res;
    }

    // dp[i][j] = (max(dp[i-1][k]) + k) + (points[i][j] - j)  k <= j;
    // dp[i][j] = (max(dp[i-1][k]) - k) + (points[i][j] + j)  k >= j;

    // TLE (需要优化dp的过程)
//    public long maxPoints2(int[][] points) {
//        this.points = points;
//        m = points.length;
//        n = points[0].length;
//        memo = new long[m][n];
//        for (long[] row : memo)
//            Arrays.fill(row, -1L);
//
//        long res = Long.MIN_VALUE;
//        for (int j = 0; j < n; j++)
//            res = Math.max(res, dfs(m - 1, j));
//        return res;
//    }
//
//    private long dfs(int i, int j) {
//        if (i == 0)
//            return points[i][j];
//        if (memo[i][j] != -1L)
//            return memo[i][j];
//        long res = Long.MIN_VALUE;
//        for (int k = 0; k < n; k++) {
//            res = Math.max(res, dfs(i - 1, k) - Math.abs(k - j));
//        }
//        res += points[i][j];
//        return memo[i][j] = res;
//    }
}
