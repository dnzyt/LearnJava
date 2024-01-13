package medium;

// 1139. Largest 1-Bordered Square

public class Solution1139 {
    // 通过二维差分数组，用大正方形减去里面小正方形得到周长
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + grid[i][j];

        if (sum[m - 1][n - 1] == 0)
            return 0;
        int ans = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = ans + 1; k <= Math.min(m, n); k++) {
                    if (i + k - 1 < m && j + k - 1 < n) {
                        int p = perimeter(sum, i, j, i + k - 1, j + k - 1);
                        if (p == (k - 1) * 4)
                            ans = Math.max(ans, k);
                    }
                }
        return ans * ans;
    }

    private int perimeter(int[][] sum, int x0, int y0, int x1, int y1) {
        int outter = sum[x1][y1]
                - (x0 == 0 ? 0 : sum[x0 - 1][y1])
                - (y0 == 0 ? 0 : sum[x1][y0 - 1])
                + (x0 == 0 || y0 == 0 ? 0 : sum[x0 - 1][y0 - 1]);
        x0 += 1;
        y0 += 1;
        x1 -= 1;
        y1 -= 1;
        int inner = Math.max(0, sum[x1][y1] - sum[x0 - 1][y1] - sum[x1][y0 - 1] + sum[x0 - 1][y0 - 1]);
        return outter - inner;
    }

}
