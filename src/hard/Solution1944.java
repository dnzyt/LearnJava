package hard;

import java.util.Stack;

public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for (int i = heights.length-1; i >= 0; i--) {
            int count = 0;
            while (!stack.empty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                count += 1;
            }

            res[i] = count + (stack.empty() ? 0 : 1);
            stack.push(i);
        }
        return res;
    }
}
