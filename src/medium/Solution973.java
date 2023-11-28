package medium;

// 973. K Closest Points to Origin

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            pq.add(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], points[i][0], points[i][1]});
            if (pq.size() > k)
                pq.poll();
        }
        List<int[]> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            res.add(new int[] {curr[1], curr[2]});
        }
        return res.toArray(int[][]::new);
    }

}
