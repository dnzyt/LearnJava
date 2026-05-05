package medium;

// 3164. Find the Number of Good Pairs II

import java.util.HashMap;
import java.util.Map;

public class Solution3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        int mx = 0;
        for (int num : nums1) {
            if (num % k == 0) {
                cnt1.merge(num / k, 1, Integer::sum);
                mx = Math.max(mx, num);
            }

        }
        long ans = 0l;
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int num : nums2)
            cnt2.merge(num, 1, Integer::sum);
        for (int num : cnt2.keySet()) {
            long c = (long) cnt2.get(num);
            for (int i = num; i <= mx; i += num) {
                ans += c * cnt1.getOrDefault(i, 0);
            }
        }
        return ans;
    }
}
