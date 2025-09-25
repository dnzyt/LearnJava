package medium;

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {

    // 滑动窗口 + 单调队列
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int left = 0;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!minQ.isEmpty() && num <= nums[minQ.peekLast()]) {
                minQ.pollLast();
            }
            minQ.offer(i);
            while (!maxQ.isEmpty() && num >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.offer(i);

            while (nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
                left++;
                if (maxQ.peek() < left)
                    maxQ.poll();
                if (minQ.peek() < left)
                    minQ.poll();
            }

            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
