package medium;

// 901. Online Stock Span

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution901 {
    static class StockSpanner {
        private List<Integer> prices;
        private Deque<Integer> st;

        public StockSpanner() {
            prices = new ArrayList<>();
            st = new ArrayDeque<>();
        }

        public int next(int price) {
            int n = prices.size();
            int ans = n + 1;
            while (!st.isEmpty() && price >= prices.get(st.peek())) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans = n - st.peek();
            }
            prices.add(price);
            st.push(n);
            return ans;
        }

    }
}
