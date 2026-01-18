package hard;

// 2354. Number of Excellent Pairs

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2354 {
    // |A⋂B| + |A⋃B| = |A| + |B|
    public long countExcellentPairs(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            if (s.contains(num)) continue;
            s.add(num);
            int bits = Integer.bitCount(num);
            cnt.merge(bits, 1, Integer::sum);
        }

        for (int bit1 : cnt.keySet())
            for (int bit2 : cnt.keySet())
                if (bit1 + bit2 >= k)
                    res += (cnt.get(bit1) * cnt.get(bit2));

        return res;
    }
}