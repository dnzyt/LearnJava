package medium;

public class Solution3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] row = new long[m];
        long[] col = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += (long) grid[i][j];
                col[j] += (long) grid[i][j];
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                ans += (row[i] - 1) * (col[j] - 1);
            }
        }

        return ans;
    }
}
