package hard;

// 1289. Minimum Falling Path Sum II

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1289 {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 1000);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                Comparator.<Pair<Integer, Integer>>comparingInt(Pair::getKey)
                        .reversed());
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
            pq.add(new Pair<>(dp[0][j], j));
            if (pq.size() > 2)
                pq.poll();
        }

        for (int i = 1; i < m; i++) {
            var second = pq.poll();
            var first = pq.poll();
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

        return Collections.min(Arrays.asList(dp[m - 1]));
    }

    public int minFallingPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        for (int j = 0; j < n; j++) {
            pq.add(new int[]{grid[m - 1][j], j});
            if (pq.size() > 2)
                pq.poll();
            f[j] = grid[m - 1][j];
        }

        for (int i = m - 2; i >= 0; i--) {
            int[] second = pq.poll();
            int[] first = pq.poll();
            for (int j = 0; j < n; j++) {
                f[j] = grid[i][j] + (j == first[1] ? second[0] : first[0]);
                pq.offer(new int[]{f[j], j});
                if (pq.size() > 2)
                    pq.poll();
            }
        }
        int res = Integer.MAX_VALUE;
        for (int num : f)
            res = Math.min(res, num);
        return res;
    }
}
