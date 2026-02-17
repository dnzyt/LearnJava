package medium;

// 3835. Count Subarrays With Cost Less Than or Equal to K

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3835 {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int n = nums.length;
        int left = 0;
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i])
                minQ.pollLast();
            minQ.offer(i);
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i])
                maxQ.pollLast();
            maxQ.offer(i);

            while ((long) (nums[maxQ.peek()] - nums[minQ.peek()]) * (i - left + 1) > k) {
                left++;
                if (minQ.peek() < left)
                    minQ.poll();
                if (maxQ.peek() < left)
                    maxQ.poll();
            }

            ans += (i - left + 1);
        }
        return ans;
    }
}
