package medium;

// 560. Subarray Sum Equals K

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    // presum + hash
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int s = 0;
        int ans = 0;
        for (int num : nums) {
            s += num;
            ans += cnt.getOrDefault(s - k, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
