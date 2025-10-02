package medium;

// 2588. Count the Number of Beautiful Subarrays

import java.util.HashMap;
import java.util.Map;

public class Solution2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Long> cnt = new HashMap<>();
        int sum = 0;
        long ans = 0;
        cnt.put(0, 1L);
        for (int num : nums) {
            sum ^= num;
            ans += cnt.getOrDefault(sum, 0L);
            cnt.merge(sum, 1L, Long::sum);
        }
        return ans;
    }
}

// 4      3        1         2          4
// 100    011      001       010        100