package medium;

// 1962. Remove Stones to Minimize the Total

import java.util.PriorityQueue;

public class Solution1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : piles)
            pq.offer(num);
        while (k-- > 0) {
            int num = pq.poll();
            pq.offer(num - (int) Math.floor((double) num / 2));
        }
        return pq.stream().mapToInt(a -> a).sum();
    }
}
