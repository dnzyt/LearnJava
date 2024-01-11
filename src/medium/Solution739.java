package medium;

// 739. Daily Temperatures

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int last = stack.pop();
                res[last] = i - last;
            }
            stack.push(i);
        }

        return res;
    }
}
