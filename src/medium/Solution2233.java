package medium;

// 2233. Maximum Product After K Increments

import java.util.PriorityQueue;

public class Solution2233 {
    public int maximumProduct(int[] nums, int k) {
        int mod = (int) Math.pow(10, 9) + 7;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)
            pq.offer(num);
        while (k-- > 0) {
            int curr = pq.poll();
            pq.offer(curr + 1);
        }
        long ans = 1;
        for (int num : pq) {
            ans = ans * num % mod;
        }
        return (int) ans;
    }
}
