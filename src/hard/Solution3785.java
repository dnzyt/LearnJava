package hard;

// 3785. Minimum Swaps to Avoid Forbidden Values

import java.util.HashMap;
import java.util.Map;

public class Solution3785 {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;
        Map<Integer, Integer> total = new HashMap<>();
        for (int num : nums) {
            total.merge(num, 1, Integer::sum);
        }
        int k = 0;
        int mx = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int f = forbidden[i];
            int x = nums[i];
            int c = total.merge(f, 1, Integer::sum);
            if (c > n)
                return -1;
            if (x == f) {
                k++;
                c = cnt.merge(x, 1, Integer::sum);
                mx = Math.max(mx, c);
            }
        }
        return Math.max((k + 1) / 2, mx);
    }
}
