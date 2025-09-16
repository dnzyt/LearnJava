package medium;

// 503. Next Greater Element II

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution503 {
    // 从前往后
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n - 1; i++) {
            int x = nums[i % n];
            while (!st.isEmpty() && x > nums[st.peek()]) {
                ans[st.pop()] = x;
            }
            if (i < n) st.push(i);
        }
        return ans;
    }

    // 从后往前
    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = nums[i % n];
            while (!st.isEmpty() && x >= nums[st.peek() % n]) {
                st.pop();
            }
            if (i < n && !st.isEmpty()) {
                ans[i] = nums[st.peek() % n];
            }
            st.push(i);
        }
        return ans;
    }
}
