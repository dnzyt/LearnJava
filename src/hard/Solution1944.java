package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 1944. Number of Visible People in a Queue

public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            int cnt = 0;
            while (!st.isEmpty() && h >= heights[st.peek()]) {
                cnt++;
                st.pop();
            }
            ans[i] = cnt + (st.isEmpty() ? 0 : 1);
            st.push(i);
        }
        return ans;
    }
}
