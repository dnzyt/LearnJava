package medium;

// 1039. Minimum Score Triangulation of Polygon

import java.util.Arrays;

public class Solution1039 {
    private int[] nums;
    private int[][] memo;

    // 区间dp
    public int minScoreTriangulation(int[] values) {
        this.nums = values;
        int n = values.length;
        this.memo = new int[n][n];
        for (int[] row : this.memo)
            Arrays.fill(row, -1);
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j || i + 1 == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MAX_VALUE / 2;
        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans, dfs(i, k) + dfs(k, j) + nums[i] * nums[j] * nums[k]);
        }
        memo[i][j] = ans;
        return ans;
    }

    public int minScoreTriangulation2(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE / 2;
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }

        return f[0][n - 1];
    }
}
