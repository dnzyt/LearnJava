package hard;

// 2742. Painting the Walls

import java.util.Arrays;

public class Solution2742 {
    private static final int MAXX = Integer.MAX_VALUE / 2;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n * 2];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(n - 1, 0, cost, time, memo);
    }

    // 考虑第i面墙时，有j个免费券可用的情况下，所产生的最小消耗
    private int dfs(int i, int j, int[] cost, int[] time, int[][] memo) {
        int n = cost.length;
        if (j > i)
            return 0;
        if (i < 0)
            return MAXX;
        if (memo[i][j + n] != -1)
            return memo[i][j + n];
        return memo[i][j + n] = Math.min(dfs(i - 1, j + time[i], cost, time, memo) +
                cost[i], dfs(i - 1, j - 1, cost, time, memo));
    }


    /*
总付费时长 >= 总免费墙数 （总免费墙数 = 总免费时长）
总付费墙数 + 总免费墙数 = n
总付费时长 + 总付费墙数 >= n
t1 + t2 + ... + tx + x >= n
(t1 + 1) + (t2 + 1) + (t3 + 1) + ... + (tx + 1) >= n
这样就转换成了至少型背包问题 ---> 总付费时长至少为n的情况下所产生的最小花费

 */
    public int paintWalls2(int[] cost, int[] time) {
        int n = cost.length;
        int[][] memo = new int[n][n + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(n - 1, n, cost, time, memo);
    }

    private int dfs2(int i, int j, int[] cost, int[] time, int[][] memo) {
        if (j <= 0)
            return 0;
        if (i < 0)
            return Integer.MAX_VALUE / 2;
        if (memo[i][j] != -1)
            return memo[i][j];
        return memo[i][j] = Math.min(dfs(i - 1, j - time[i] - 1, cost, time, memo) + cost[i], dfs(i - 1, j, cost, time, memo));
    }
}
