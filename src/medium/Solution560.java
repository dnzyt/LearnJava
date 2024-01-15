package medium;

// 560. Subarray Sum Equals K

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    // presum + hash
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int sum = 0;
        int res = 0;
        count.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (count.containsKey(sum - k))
                res += count.get(sum - k);
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
