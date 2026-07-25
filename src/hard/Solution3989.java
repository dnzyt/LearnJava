package hard;

// 3989. Maximum Consistent Columns in a Grid

import java.util.Arrays;

public class Solution3989 {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            int mx = 0;
            for (int j = 0; j < i; j++) {
                if (mx >= f[j])
                    continue;
                boolean find = true;
                for (int k = 0; k < m; k++) {
                    if (Math.abs(grid[i][k] - grid[j][k]) > limit) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    f[i] = Math.max(f[i], f[j] + 1);
                    mx = f[j];
                }
            }
        }
        return Arrays.stream(f).max().getAsInt();
    }
}
