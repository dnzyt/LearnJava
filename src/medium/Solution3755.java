package medium;

// 3755. Find Maximum Balanced XOR Subarray Length

import java.util.HashMap;
import java.util.Map;

public class Solution3755 {
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        int[] prexor = new int[n + 1];
        int[] even = new int[n + 1];
        int t = 0;
        for (int i = 0; i < n; i++) {
            prexor[i + 1] = prexor[i] ^ nums[i];
            if (nums[i] % 2 == 0)
                t++;
            even[i + 1] = t;
        }

        Map<Long, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long key = (prexor[i + 1] & 0xFFFFFFFFL) << 32;
            key |= ((i + 1 - 2L * even[i + 1]) & 0xFFFFFFFFL);
            if (map.containsKey(key)) {
                ans = Math.max(ans, i - map.get(key) + 1);
            }
            key = (prexor[i] & 0xFFFFFFFFL) << 32;
            key |= (i - 2L * even[i]) & 0xFFFFFFFFL;
            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }
        return ans;
    }
}
