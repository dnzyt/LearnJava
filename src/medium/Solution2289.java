package medium;


import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 2289. Steps to Make Array Non-decreasing

public class Solution2289 {
    // 所有比当前元素小的值都被消去之后才能消去当前元素
    // 所以当前元素消去的时间点是之前比自己小的元素的时间点+1
    public int totalSteps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Deque<int[]> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int maxTime = 0;
            while (!st.isEmpty() && nums[st.peek()[0]] <= nums[i]) {
                int[] x = st.pop();
                maxTime = Math.max(maxTime, x[1]);
            }
            // 如果栈为空，那么说明这个值不能消去，这个时候时间点是无意义的，只要不影响取到最大值就行
            // 不能做++操作，不然会影响取到最大值
            if (!st.isEmpty())
                maxTime++;
            st.push(new int[]{i, maxTime});
            ans = Math.max(ans, maxTime);
        }
        return ans;
    }
}
