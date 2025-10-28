package medium;

// 3275. K-th Nearest Obstacle Queries

import java.util.PriorityQueue;

public class Solution3275 {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            pq.offer(Math.abs(a) + Math.abs(b));
            if (pq.size() > k)
                pq.poll();
            if (pq.size() < k)
                ans[i] = -1;
            else
                ans[i] = pq.peek();
        }
        return ans;
    }
}
