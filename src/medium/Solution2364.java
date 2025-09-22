package medium;

// 2364. Count Number of Bad Pairs

import java.util.HashMap;
import java.util.Map;

public class Solution2364 {
    public long countBadPairs(int[] nums) {
        long n = (long) nums.length;
        Map<Integer, Long> cnt = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int v = nums[i] - i;
            ans += cnt.getOrDefault(v, 0L);
            cnt.put(v, cnt.getOrDefault(v, 0L) + 1L);
        }
        return n * (n - 1) / 2 - ans;
    }
}

// j - i = nums[j] - nums[i]
// nums[j] - j = nums[i] - i
