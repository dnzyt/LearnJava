package medium;

// 3026. Maximum Good Subarray Sum

import java.util.HashMap;
import java.util.Map;

public class Solution3026 {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> cnt = new HashMap<>();
        long ans = Long.MIN_VALUE;
        long sum = 0;
        for (int num : nums) {
            if (cnt.containsKey(num + k))
                ans = Math.max(ans, sum + num - cnt.get(num + k));
            if (cnt.containsKey(num - k))
                ans = Math.max(ans, sum + num - cnt.get(num - k));
            cnt.put(num, Math.min(sum, cnt.getOrDefault(num, Long.MAX_VALUE)));
            sum += num;
        }

        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}
