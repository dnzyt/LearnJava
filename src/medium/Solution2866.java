package medium;

import java.util.List;
import java.util.Stack;

public class Solution2866 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        maxHeights.add(0, 0);
        maxHeights.add(0);
        long[] presum = new long[n + 1];
        long[] postsum = new long[n + 2];

        long res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.empty() && maxHeights.get(i) < maxHeights.get(stack.peek())) {
                stack.pop();
            }
            int j = 0;
            if (!stack.empty())
                j = stack.peek();
            presum[i] = presum[j] + (long) maxHeights.get(i) * (i - j);
            stack.add(i);
        }
        stack.clear();
        for (int i = n; i >= 1; i--) {
            while (!stack.empty() && maxHeights.get(i) < maxHeights.get(stack.peek())) {
                stack.pop();
            }
            int j = n + 1;
            if (!stack.empty())
                j = stack.peek();
            postsum[i] = postsum[j] + (long) maxHeights.get(i) * (j - i);
            stack.add(i);
        }
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, presum[i] + postsum[i] - maxHeights.get(i));
        }

        return res;
    }
}
