package hard;

// 239. Sliding Window Maximum

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!q.isEmpty() && num >= nums[q.peek()]) {
                q.poll();
            }
            q.offerFirst(i);
            if (i - q.peekLast() == k) q.pollLast();
            if (i >= k - 1) ans[i - k + 1] = nums[q.peekLast()];
        }
        return ans;
    }
}
