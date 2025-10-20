package medium;

// 1381. Design a Stack With Increment Operation

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1381 {
    class CustomStack {

        private int[] inc;
        private List<Integer> stack;
        private int n;

        public CustomStack(int maxSize) {
            n = maxSize;
            stack = new ArrayList<>();
            inc = new int[n];
        }

        public void push(int x) {
            if (stack.size() == n)
                return;
            stack.add(x);
        }

        public int pop() {
            if (stack.isEmpty())
                return -1;
            int idx = stack.size() - 1;
            int ans = stack.remove(idx);

            if (idx > 0)
                inc[idx - 1] += inc[idx];
            ans += inc[idx];
            inc[idx] = 0;
            return ans;
        }

        public void increment(int k, int val) {
            k = Math.min(k, stack.size()) - 1;
            if (k >= 0)
                inc[k] += val;
        }
    }
}
