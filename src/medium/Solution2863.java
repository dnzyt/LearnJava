package medium;

import java.util.Stack;

// 2863. Maximum Length of Semi-Decreasing Subarrays

public class Solution2863 {
    // 单调递增栈
    public int maxSubarrayLength(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] > nums[stack.peek()])
                stack.push(i);
        }
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.empty() && nums[i] < nums[stack.peek()]) {
                int lastIdx = stack.pop();
                res = Math.max(res, i - lastIdx + 1);
            }
        }

        return res;
    }


}
