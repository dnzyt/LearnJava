package hard;

// 2334. Subarray With Elements Greater Than Varying Threshold

import java.util.Arrays;
import java.util.Stack;

// 2334. Subarray With Elements Greater Than Varying Threshold

public class Solution2334 {

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && nums[i] < nums[stack.peek()])
                nextSmaller[stack.pop()] = i;
            stack.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[i] < nums[stack.peek()])
                prevSmaller[stack.pop()] = i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int l = (nextSmaller[i] - 1) - prevSmaller[i];

            if (nums[i] * l > threshold)
                return l;
        }

        return -1;
    }

}
