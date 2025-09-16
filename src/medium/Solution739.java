package medium;

// 739. Daily Temperatures

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                Integer last = st.pop();
                ans[last] = i - last;
            }
            st.push(i);
        }

        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        return ans;
    }
}
