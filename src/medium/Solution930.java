package medium;

// 930. Binary Subarrays With Sum

import java.util.HashMap;
import java.util.Map;

public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] presum = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += nums[i];
            presum[i] = t;
        }
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int diff = presum[i] - goal;
            if (m.containsKey(diff)) {
                res += m.get(diff);
            }
            m.put(presum[i], m.getOrDefault(presum[i], 0) + 1);
        }
        return res;
    }
}
