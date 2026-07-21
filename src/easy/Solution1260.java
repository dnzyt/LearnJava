package easy;

// 1260. Shift 2D Grid

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int size = m * n;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int seq = i * m + j;
                int newSeq = (seq + k) % size;
                ans[newSeq / n][newSeq % n] = grid[i][j];
            }
        }
        List<List<Integer>> s = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            s.add(Arrays.stream(ans[i]).boxed().toList());
        }
        return s;
    }
}
