package medium;

// 454. 4Sum II

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a : nums1)
            for (int b : nums2) {
                cnt.merge(a + b, 1, Integer::sum);
            }

        int ans = 0;
        for (int a : nums3)
            for (int b : nums4) {
                ans += cnt.getOrDefault(-(a + b), 0);
            }

        return ans;
    }
}
