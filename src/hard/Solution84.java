package hard;

import java.util.Arrays;
import java.util.Stack;

// 84. Largest Rectangle in Histogram

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
                // 在相等的情况下，此时的next smaller是错误的
                // 但是在遍历到最后那个相等的数时是正确的，所以不会影响计算result
                // ... 5 ... 5 .... 5...
                // 前面两个5的next smaller都是错的
                // 最后的那个5会有正确的next smaller
                nextSmaller[idx] = i;

                // 如果不想考虑这种tricky的情况，就吧pre和next smaller分开算
                // 从前往后走计算next smaller
                // 从后往前再走一遍计算pre smaller

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
