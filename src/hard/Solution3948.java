package hard;

// 3948. Lexicographically Maximum MEX Array

import java.util.*;

public class Solution3948 {
    public int[] maximumMEX(int[] nums) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayDeque<>()).offer(i);
        }
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < n) {
            int p = 0;
            int right = i;
            while (map.containsKey(p) && !map.get(p).isEmpty()) {
                Deque<Integer> d = map.get(p);
                while (!d.isEmpty() && d.peek() < i)
                    d.poll();
                if (d.isEmpty()) {
                    break;
                }
                right = Math.max(right, d.poll());
                p++;
            }
            ans.add(p);
            i = right + 1;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
