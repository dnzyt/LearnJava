package medium;

// 3868. Minimum Cost to Equalize Arrays Using Swaps

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3868 {
    public int minCost(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int num : nums1) {
            cnt.merge(num, 1, Integer::sum);
        }
        for (int num : nums2) {
            cnt.merge(num, -1, Integer::sum);
        }
        int ans = 0;
        for (int val : cnt.values()) {
            if (val % 2 != 0)
                return -1;
            ans += Math.abs(val);
        }


        return ans / 4;
    }
}
