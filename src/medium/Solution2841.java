package medium;

// 2841. Maximum Sum of Almost Unique Subarray

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0L, sum = 0L;
        int l = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            cnt.merge(curr, 1, Integer::sum);
            sum += curr;
            if (i - l + 1 > k) {
                cnt.merge(nums.get(l), -1, Integer::sum);
                sum -= nums.get(l);
                if (cnt.get(nums.get(l)) == 0)
                    cnt.remove(nums.get(l));
                l++;
            }
            if (cnt.size() >= m && i - l + 1 == k)
                ans = Math.max(ans, sum);
        }
        return ans;
    }
}
