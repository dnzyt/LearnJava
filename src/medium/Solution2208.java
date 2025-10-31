package medium;

// 2208. Minimum Operations to Halve Array Sum

import java.util.PriorityQueue;

public class Solution2208 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            pq.offer((double) num);
            sum += num;
        }
        int ans = 0;
        double sum2 = sum;
        while (sum2 > sum / 2) {
            double x = pq.poll();
            sum2 -= x / 2;
            pq.offer(x / 2);
            ans++;
        }
        return ans;
    }
}
