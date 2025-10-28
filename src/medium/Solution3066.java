package medium;

// 3066. Minimum Operations to Exceed Threshold Value II

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Solution3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.addAll(IntStream.of(nums).mapToLong(a -> a).boxed().toList());
        int ans = 0;
        while (pq.peek() < k) {
            Long a = pq.poll();
            Long b = pq.poll();
            pq.offer(Math.min(a, b) * 2 + Math.max(a, b));
            ans++;
        }
        return ans;
    }
}
