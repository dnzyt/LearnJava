package medium;

// 523. Continuous Subarray Sum

import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (cnt.containsKey(sum % k)) {
                int left = cnt.get(sum % k);
                if (i - left >= 2)
                    return true;
            } else {
                cnt.put(sum % k, i);
            }
        }
        return false;
    }
}
