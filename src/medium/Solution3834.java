package medium;

// 3834. Merge Adjacent Equal Elements

import java.util.*;

public class Solution3834 {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        Deque<Long> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            Long curr = (long) nums[i];
            while (!st.isEmpty() && st.peek().equals(curr)) {
                curr += st.pop();
            }
            st.push(curr);
        }
        List<Long> ans = new ArrayList(st);
        Collections.reverse(ans);
        return ans;
    }
}
