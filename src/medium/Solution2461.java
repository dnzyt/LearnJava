package medium;

// 2461. Maximum Sum of Distinct Subarrays With Length K

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0L, sum = 0L;
        int l = 0;
        for (int i = 0; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
            if (i - l + 1 > k) {
                sum -= nums[l];
                cnt.merge(nums[l], -1, Integer::sum);
                if (cnt.get(nums[l]) == 0)
                    cnt.remove(nums[l]);
                l++;
            }
            if (i - l + 1 == k && cnt.size() == k)
                ans = Math.max(ans, sum);
        }
        return ans;
    }
}
