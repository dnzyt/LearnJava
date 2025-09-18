package medium;

// 1696. Jump Game VI

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Solution1696 {
    // 单调队列 + 滑动窗口
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!q.isEmpty() && i - q.peek() > k)
                q.poll();
            if (!q.isEmpty()) {
                res[i] = res[q.peek()] + num;
            }
            while (!q.isEmpty() && res[i] >= res[q.peekLast()])
                q.pollLast();
            q.offer(i);
        }

        return res[n - 1];
    }
}
