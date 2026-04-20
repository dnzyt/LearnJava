package hard;

// 3548. Equal Sum Grid Partition II

import java.util.HashSet;
import java.util.Set;

public class Solution3548 {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0l;
        for (int[] row : grid)
            for (int i = 0; i < row.length; i++)
                total += row[i];
        if (check(grid, total))
            return true;
        flip(grid);
        if (check(grid, total))
            return true;
        grid = rotate(grid);
        if (check(grid, total))
            return true;
        flip(grid);
        if (check(grid, total))
            return true;
        return false;

    }

    private boolean check(int[][] grid, long total) {
        Set<Long> set = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        long s = 0l;

        for (int i = 0; i < m - 1; i++) {
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                s += row[j];
                if (i > 0 || j == 0 || j == n - 1)
                    set.add((long) row[j]);
            }
            if (n == 1) {
                if (2 * s == total || 2 * s - grid[0][0] == total || 2 * s - row[0] == total)
                    return true;
                continue;
            }
            if (set.contains(2 * s - total) || 2 * s == total)
                return true;
            if (i == 0) {
                for (int num : grid[0])
                    set.add((long) num);
            }
        }
        return false;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] b = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++)
                b[j][i] = grid[i][j];
        }
        return b;
    }

    private void flip(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = grid[i][j];
                grid[i][j] = grid[m - 1 - i][j];
                grid[m - 1 - i][j] = tmp;
            }
        }
    }
}
