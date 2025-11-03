package hard;

// 2931. Maximum Spending After Buying Items

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2931 {
    public long maxSpending(int[][] values) {
        long ans = 0;
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < m; i++)
            pq.offer(new int[]{values[i][n - 1], i, n - 1});

        int d = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans += (long) d * curr[0];
            d++;
            if (curr[2] != 0)
                pq.offer(new int[]{values[curr[1]][curr[2] - 1], curr[1], curr[2] - 1});
        }
        return ans;
    }
}
