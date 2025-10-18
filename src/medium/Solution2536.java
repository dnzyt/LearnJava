package medium;

// 2536. Increment Submatrices by One

import java.util.Arrays;

public class Solution2536 {
    // 对二维差分数组求前缀和就能还原为原数组
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] d = new int[n + 1][n + 1];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            d[r1][c1] += 1;
            d[r1][c2 + 1] -= 1;
            d[r2 + 1][c1] -= 1;
            d[r2 + 1][c2 + 1] += 1;
        }

        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                f[i + 1][j + 1] = f[i][j + 1] + f[i + 1][j] - f[i][j] + d[i][j];
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++)
            ans[i] = Arrays.copyOfRange(f[i + 1], 1, n + 1);
        return ans;
    }
}
