package hard;

import java.util.Arrays;
import java.util.Stack;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;

        int[] preSmaller = new int[n];
        Arrays.fill(preSmaller, -1);
        int[] nextSmaller = new int[n];
        Arrays.fill(nextSmaller, n);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[i] <= heights[stack.peek()]) {
                int idx = stack.pop();
                nextSmaller[idx] = i;
            }
            if (!stack.empty())
                preSmaller[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++)
            res = Math.max(res, heights[i] * ((nextSmaller[i] - 1) - preSmaller[i]));
        return res;
    }
}
