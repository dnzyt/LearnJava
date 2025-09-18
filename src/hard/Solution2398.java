package hard;


import java.util.ArrayDeque;
import java.util.Deque;

// 2398. Maximum Number of Robots Within Budget
public class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] +runningCosts[i];
        }

        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            int t = chargeTimes[j];
            while (!q.isEmpty() && t >= chargeTimes[q.peekLast()])
                q.pollLast();
            q.offer(j);
            while (!q.isEmpty() && chargeTimes[q.peek()] + (j - i + 1) * (presum[j + 1] - presum[i]) > budget) {
                i++;
                if (q.peek() < i)
                    q.poll();

            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
