package hard;

// 1499. Max Value of Equation

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1499 {
    // yi + yj + |xi - xj|
    // yj + xj + (yi - xi)

    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++)
            diff[i] = points[i][1] - points[i][0];
        Deque<Integer> q = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            int d = y - x;

            while (!q.isEmpty() && x - points[q.peek()][0] > k) {
                q.poll();
            }

            if (!q.isEmpty()) {
                ans = Math.max(ans, x + y + diff[q.peek()]);
            }
            while (!q.isEmpty() && d > diff[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return ans;
    }
}
