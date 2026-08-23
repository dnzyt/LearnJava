package medium;

// 2958. Length of Longest Subarray With at Most K Frequency

import java.util.HashMap;
import java.util.Map;

public class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.length;
        int ans = 0, j = 0;
        for (int i = 0; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            while (cnt.get(nums[i]) > k) {
                cnt.merge(nums[j], -1, Integer::sum);
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
