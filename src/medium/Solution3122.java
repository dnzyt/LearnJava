package medium;

// 3122. Minimum Number of Operations to Satisfy Conditions

import java.util.Arrays;

public class Solution3122 {
    private int[][] grid;
    private int[][] memo;
    private int[][] cnt;

    public int minimumOperations(int[][] grid) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        cnt = new int[n][10];
        memo = new int[n][11];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                cnt[j][grid[i][j]]++;
        }
        return m * n - dfs(n - 1, 10);
    }

    private int dfs(int i, int pre) {
        if (i == -1)
            return 0;
        if (memo[i][pre] != -1)
            return memo[i][pre];
        int ans = 0;
        for (int x = 0; x <= 9; x++) {
            if (x == pre)
                continue;
            ans = Math.max(ans, cnt[i][x] + dfs(i - 1, x));
        }
        return memo[i][pre] = ans;
    }
}
