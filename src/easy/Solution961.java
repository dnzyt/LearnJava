package easy;

// 961. N-Repeated Element in Size 2N Array

import java.util.HashMap;
import java.util.Map;

public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            if (cnt.get(nums[i]) > 1)
                return nums[i];
        }
        return -1;
    }
}

