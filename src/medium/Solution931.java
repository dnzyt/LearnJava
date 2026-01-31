package medium;

// 931. Minimum Falling Path Sum

import java.util.Arrays;

public class Solution931 {
    private int[][] matrix;
    private int[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        this.memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++)
            res = Math.min(res, dfs(m - 1, i));
        return res;
    }

    private int dfs(int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        if (j < 0 || j >= n)
            return Integer.MAX_VALUE;
        if (i == 0)
            return matrix[0][j];
        if (memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];

        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j - 1), dfs(i - 1, j)), dfs(i - 1, j + 1)) + matrix[i][j];
    }
}
