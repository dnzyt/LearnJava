package hard;

// 862. Shortest Subarray with Sum at Least K

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + nums[i];
        Deque<Integer> q = new ArrayDeque<>();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!q.isEmpty() && presum[i + 1] > presum[q.peek() + 1])
                q.pollLast();
            q.offer(i);
            while (!q.isEmpty() && presum[i + 1] - presum[q.peek() + 1] >= k) {
                ans = Math.min(ans, i - q.peek());
                q.poll();
            }
        }
        return ans;
    }
}
