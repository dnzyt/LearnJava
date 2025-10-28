package medium;

// 2530. Maximal Score After Applying K Operations

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2530 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long ans = 0;
        pq.addAll(Arrays.stream(nums).boxed().toList());
        while (k-- > 0) {
            int curr = pq.poll();
            ans += curr;
            pq.offer((int) Math.ceil((double) curr / 3));
        }
        return ans;
    }
}
