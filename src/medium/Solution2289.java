package medium;


import javafx.util.Pair;

import java.util.LinkedList;

public class Solution2289 {
    public int totalSteps(int[] nums) {
        LinkedList<Pair<Integer, Integer>> deque = new LinkedList<>();
        deque.offerLast(new Pair<Integer, Integer>(nums[0], 0));
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            var p = deque.peekFirst();
            if (p.getKey() <= nums[i]) {
                deque.clear();
                deque.offerLast(new Pair<>(nums[i], 0));
                continue;
            }
            int round = 1;
            while (!deque.isEmpty() && deque.peekLast().getKey() <= nums[i]) {
                var last = deque.pollLast();
                round = Math.max(round, last.getValue()+1);
            }
            deque.offerLast(new Pair<>(nums[i], round));
            res = Math.max(res, round);
        }

        return res;
    }
}
