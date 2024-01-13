package hard;

// 992. Subarrays with K Different Integers

import java.util.HashMap;
import java.util.Map;

public class Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // unique的数字<=k的subarray的数量
        // 滑动窗口越大，unique的数字越多，具有单调性
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (!counter.containsKey(nums[r])) {
                counter.put(nums[r], 0);
            }
            int num = counter.get(nums[r]);
            counter.put(nums[r], num + 1);
            while (l <= r && counter.size() > k) {
                int temp = counter.get(nums[l]);
                counter.put(nums[l], temp - 1);
                if (counter.get(nums[l]) == 0)
                    counter.remove(nums[l]);
                l += 1;
            }
            res += (r - l) + 1;
        }
        return res;
    }
}
