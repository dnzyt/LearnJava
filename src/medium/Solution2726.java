package medium;

// 2762. Continuous Subarrays

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2726 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        long ans = 0L;
        int left = 0;

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= curr)
                minQ.pollLast();
            minQ.offer(i);
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= curr)
                maxQ.pollLast();
            maxQ.offer(i);

            while (nums[maxQ.peek()] - nums[minQ.peek()] > 2) {
                left++;
                if (maxQ.peek() < left)
                    maxQ.poll();
                if (minQ.peek() < left)
                    minQ.poll();
            }
            ans += (i - left + 1);
        }
        return ans;
    }
}
