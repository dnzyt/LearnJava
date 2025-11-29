package easy;

// 3728. Stable Subarrays With Equal Boundary and Interior Sum

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3728 {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + capacity[i];
        }

        Map<Long, Long> count = new HashMap<>();
        Map<Long, List<Integer>> indices = new HashMap<>();
        long ans = 0;
        // (c[l], c[l] + presum[l+1]) = (c[r], presum[r])
        for (int i = 0; i < n; i++) {
            long key = ((capacity[i] & 0xFFFFFFFFL) << 32) + presum[i];
            if (count.containsKey(key)) {
                long v = count.get(key);
                List<Integer> positions = indices.get(key);
                for (int idx = positions.size() - 1; idx >= 0; idx--) {
                    if (i - positions.get(idx) < 2) // 确保长度不小于3
                        v--;
                    else
                        break;
                }
                ans += v;
            }


            key = ((capacity[i] & 0xFFFFFFFFL) << 32) + (capacity[i] + presum[i + 1]);
            count.merge(key, 1L, Long::sum);
            if (!indices.containsKey(key))
                indices.put(key, new ArrayList<>());
            indices.get(key).add(i);
        }
        return ans;
    }
}

/*
 * c[l] = c[r] = presum[r] - presum[l+1]
 * =>
 * c[l] = c[r]
 * c[l] + presum[l+1] = presum[r]
 *
 * =>
 *
 * (c[l], c[l] + presum[l+1]) = (c[r], presum[r])
 * python可以用tuple作为key,java用一个long作为key
 *
 * */