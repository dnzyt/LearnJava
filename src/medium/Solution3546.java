package medium;

// 3546. Equal Sum Grid Partition I

public class Solution3546 {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] rows = new long[m], cols = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        long[] presum = new long[m + 1];
        for (int i = 0; i < m; i++)
            presum[i + 1] = presum[i] + rows[i];
        long[] suffix = new long[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + rows[i];
            if (presum[i] == suffix[i])
                return true;
        }
        presum = new long[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + cols[i];
        suffix = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + cols[i];
            if (presum[i] == suffix[i])
                return true;
        }


        return false;
    }
}
