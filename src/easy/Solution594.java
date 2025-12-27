package easy;

// 594. Longest Harmonious Subsequence

import java.util.HashMap;
import java.util.Map;

public class Solution594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        int ans = 0;
        for (int k : cnt.keySet()) {
            ans = Math.max(ans, cnt.get(k) + cnt.getOrDefault(k + 1, -cnt.get(k)));
        }
        return ans;
    }
}
