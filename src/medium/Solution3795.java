package medium;

// 3795. Minimum Subarray Length With Distinct Sum At Least K

import java.util.HashMap;
import java.util.Map;

public class Solution3795 {
    public int minLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int i = 0, n = nums.length;
        int sum = 0, ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (!cnt.containsKey(nums[j]))
                sum += nums[j];
            cnt.merge(nums[j], 1, Integer::sum);
            while (i <= j && sum >= k) {
                ans = Math.min(ans, j - i + 1);
                cnt.merge(nums[i], -1, Integer::sum);
                if (cnt.get(nums[i]) == 0) {
                    cnt.remove(nums[i]);
                    sum -= nums[i];
                }
                i++;
            }
        }
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}
