package easy;

// 2441. Largest Positive Integer That Exists With Its Negative

import java.util.HashSet;
import java.util.Set;

public class Solution2441 {
    public int findMaxK(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(-num)) {
                ans = Math.max(ans, Math.abs(num));
            }
            set.add(num);

        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
