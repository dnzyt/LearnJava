package hard;

// 2132. Stamping the Grid

public class Solution2132 {
    // 前缀和数组 + 差分数组
    // 前缀和数组可以快速确定当前点为左上角时是否可以贴邮票
    // 差分数组用来快速贴邮票，然后还原成原数组
    public boolean possibleToStamp(int[][] grid, int sh, int sw) {
        int m = grid.length, n = grid[0].length;
        int[][] presum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                presum[i + 1][j + 1] = presum[i][j + 1] + presum[i + 1][j] - presum[i][j] + grid[i][j];
            }
        }

        int[][] d = new int[m + 2][n + 2];
        for (int i = 0; i <= m - sh; i++) {
            for (int j = 0; j <= n - sw; j++) {
                int x = i + sh - 1;
                int y = j + sw - 1;
                if (presum[x + 1][y + 1] - presum[x + 1][j] - presum[i][y + 1] + presum[i][j] > 0) continue;
                d[i + 1][j + 1] += 1;
                d[i + 1][y + 2] -= 1;
                d[x + 2][j + 1] -= 1;
                d[x + 2][y + 2] += 1;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1];
                if (grid[i - 1][j - 1] == 0 && d[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

}
