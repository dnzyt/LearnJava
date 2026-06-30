package medium;

// 2352. Equal Row and Column Pairs

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2352 {
    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for (int num : row)
                arr.add(num);
            cnt.merge(arr, 1, Integer::sum);
        }
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < grid.length; i++) {
                arr.add(grid[i][j]);
            }
            ans += cnt.getOrDefault(arr, 0);
        }
        return ans;
    }
}
