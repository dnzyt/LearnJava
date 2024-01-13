package hard;

// 2132. Stamping the Grid

public class Solution2132 {
    // 前缀和数组 + 差分数组
    // 前缀和数组可以快速确定当前点为左上角时是否可以贴邮票
    // 差分数组用来统计贴完邮票之后是否还有空闲点
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        int[][] presum = new int[m + 1][n + 1]; // 前缀和数组
        int[][] diff = new int[m + 1][n + 1];   // 差分数组
        int[][] f = new int[m][n];              // 差分数组结算后的最终数组

        // 计算前缀和数组
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + grid[i - 1][j - 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                int x1 = i + stampHeight - 1;
                int y1 = j + stampWidth - 1;
                if (x1 >= m || y1 >= n) continue;
                // 查看当前区域是否可以贴邮票
                int rangeSum = presum[x1 + 1][y1 + 1] - presum[x1 + 1][j] - presum[i][y1 + 1] + presum[i][j];
                if (rangeSum == 0) {
                    // 贴邮票
                    diff[i][j] += 1;
                    diff[i][y1 + 1] -= 1;
                    diff[x1 + 1][j] -= 1;
                    diff[x1 + 1][y1 + 1] += 1;
                }
            }
        // 结算差分数组
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int a = i == 0 ? 0 : f[i - 1][j];
                int b = j == 0 ? 0 : f[i][j - 1];
                int c = (i == 0 || j == 0) ? 0 : f[i - 1][j - 1];
                f[i][j] = a + b - c + diff[i][j];
            }
        // 看贴完邮票之后还是否有空闲位置
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                if (f[i][j] == 0) return false;
            }
        return true;
    }

}
