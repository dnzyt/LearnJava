package medium;

// 56. Merge Intervals

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int start = -1, end = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (start == -1 && end == -1) {
                start = curr[0];
                end = curr[1];
                continue;
            }

            if (curr[0] > end) {
                res.add(new int[] { start, end });
                start = curr[0];
                end = curr[1];
            } else {
                end = Math.max(end, curr[1]);
            }
        }
        res.add(new int[] { start, end });
        return res.toArray(int[][]::new);
    }

}
