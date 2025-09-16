package easy;

// 1475. Final Prices With a Special Discount in a Shop

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1475 {
    // 从前往后
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                int idx = st.pop();
                ans[idx] -= prices[i];
            }
            st.push(i);
        }

        return ans;
    }

    // 从后往前
    public int[] finalPrices2(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = prices[i];
            while (!st.isEmpty() && prices[i] < prices[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] -= prices[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }
}
