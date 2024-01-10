package medium;

// 974. Subarray Sums Divisible by K

import java.util.HashMap;
import java.util.Map;

public class Solution974 {
    /*
    * 如果不同的前缀和有相同的余数，那么他们之间的range sum就能被k整除
    * */
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += nums[i];
            presum[i] = t;
        }

        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        m.put(0, 1);
        for (int i = 0; i < n; i++) {
            int remainder = (presum[i] % k + k) % k;
            if (m.containsKey(remainder)) {
                res += m.get(remainder);
            }
            m.put(remainder, m.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
}
