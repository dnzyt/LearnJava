package medium;

// 3567. Minimum Absolute Difference in Sliding Submatrix

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3567 {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                List<Integer> a = new ArrayList<>();
                for (int x = 0; x < k; x++)
                    for (int y = 0; y < k; y++)
                        a.add(grid[i + x][j + y]);
                Collections.sort(a);
                int res = Integer.MAX_VALUE;
                for (int p = 1; p < a.size(); p++) {
                    if (a.get(p - 1) < a.get(p))
                        res = Math.min(res, a.get(p) - a.get(p - 1));
                }
                ans[i][j] = res < Integer.MAX_VALUE ? res : 0;
            }
        }
        return ans;
    }
}
