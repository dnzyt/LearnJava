package medium;

// 2462. Total Cost to Hire K Workers

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        Set<Integer> used = new HashSet<>();
        int l = 0, r = n - 1;
        PriorityQueue<int[]> left = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));
        PriorityQueue<int[]> right = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0]).thenComparing(a -> a[1]));
        long ans = 0;
        while (k-- > 0) {
            while (l <= r && left.size() < candidates) {
                left.offer(new int[]{costs[l], l++});
            }
            while (l <= r && right.size() < candidates) {
                right.offer(new int[]{costs[r], r--});
            }
            if (left.isEmpty()) {
                int[] c = right.poll();
                ans += c[0];
            } else if (right.isEmpty()) {
                int[] c = left.poll();
                ans += c[0];
            } else {
                if (left.peek()[0] <= right.peek()[0]) {
                    int[] c = left.poll();
                    ans += c[0];
                } else {
                    int[] c = right.poll();
                    ans += c[0];
                }
            }
        }
        return ans;
    }
}
