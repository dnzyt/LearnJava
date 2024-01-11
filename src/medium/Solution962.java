package medium;

// 962. Maximum Width Ramp

import java.util.Stack;

public class Solution962 {
    // O(n)
    // 这道题不是单调站的经典用法(nextSmaller, prevSmaller)，而是用单调站维护了解的可能性
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[stack.peek()] > nums[i])
                stack.add(i);
        }

        int res = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i]) {
                int last = stack.pop();
                res = Math.max(res, i - last);
            }
            if (stack.empty()) break;
        }
        return res;
    }
}
