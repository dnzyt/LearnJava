package medium;

// 930. Binary Subarrays With Sum

import java.util.HashMap;
import java.util.Map;

public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (cnt.containsKey(sum - goal))
                ans += cnt.get(sum - goal);
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
