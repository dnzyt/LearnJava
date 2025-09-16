package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

// 84. Largest Rectangle in Histogram

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, -1);
        Arrays.fill(r, n);
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!st.isEmpty() && h <= heights[st.peek()]) {
                int idx = st.pop();
                r[idx] = i;
            }
            if (!st.isEmpty()) l[i] = st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (r[i] - l[i] - 1) * heights[i]);
        }
        return ans;
    }
}
