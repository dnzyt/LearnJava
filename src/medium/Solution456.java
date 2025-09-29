package medium;

// 456. 132 Pattern

import java.util.*;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] < second) return true;
            while (!st.isEmpty() && nums[j] > st.peek())
                second = Math.max(second, st.pop());
            st.push(nums[j]);
        }
        return false;

    }
}
