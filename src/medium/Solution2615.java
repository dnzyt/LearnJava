package medium;

// 2615. Sum of Distances

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Long>> map = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Long> l = map.getOrDefault(nums[i], new ArrayList<>(List.of(0L)));
            idx.put(i, l.size() - 1);
            l.add(l.get(l.size() - 1) + i);
            map.put(nums[i], l);
        }

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int j = idx.get(i);
            List<Long> presum = map.get(nums[i]);
            long left = (long) j * i - presum.get(j);
            long right = presum.get(presum.size() - 1) - presum.get(j + 1) - (long) i * (presum.size() - 2 - j);
            ans[i] = left + right;
        }

        return ans;
    }
}
