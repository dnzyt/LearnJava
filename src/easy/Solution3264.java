package easy;

// 3264. Final Array State After K Multiplication Operations I

import javafx.util.Pair;

import java.util.PriorityQueue;

public class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getKey().equals(b.getKey()))
                return a.getValue() - b.getValue();
            return a.getKey() - b.getKey();
        });
        for (int i = 0; i < n; i++)
            pq.offer(new Pair<>(nums[i], i));
        while (k-- > 0) {
            Pair<Integer, Integer> p = pq.poll();
            p = new Pair<>(p.getKey() * multiplier, p.getValue());
            pq.offer(p);
        }
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();
            nums[p.getValue()] = p.getKey();
        }
        return nums;
    }

}
