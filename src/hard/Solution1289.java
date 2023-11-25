package hard;

// 1289. Minimum Falling Path Sum II

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution1289 {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 1000);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
            pq.add(new Pair<>(dp[0][j], j));
            if (pq.size() > 2)
                pq.poll();
        }

        for (int i = 1; i < m; i++) {
            var first = pq.poll();
            var second = pq.poll();
            for (int j = 0; j < n; j++) {
                if (j == first.getValue())
                    dp[i][j] = second.getKey() + grid[i][j];
                else
                    dp[i][j] = first.getKey() + grid[i][j];
                pq.add(new Pair<>(dp[i][j], j));
                if (pq.size() > 2)
                    pq.poll();
            }
        }

        return Collections.max(Arrays.asList(dp[m - 1]));
    }

}
