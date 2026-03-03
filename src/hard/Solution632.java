package hard;

// 632. Smallest Range Covering Elements from K Lists

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i).get(0);
            pq.offer(new int[]{num, i, 0});
            if (r < num)
                r = num;
        }
        int ansL = pq.peek()[0];
        int ansR = r;
        while (pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()) {
            int[] top = pq.poll();
            top[0] = nums.get(top[1]).get(++top[2]);
            r = Math.max(r, top[0]);
            pq.offer(top);
            int l = pq.peek()[0];
            if (r - l < ansR - ansL) {
                ansL = l;
                ansR = r;
            }
        }
        return new int[]{ansL, ansR};
    }
}
