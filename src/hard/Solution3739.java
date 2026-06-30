package hard;

// 3739. Count Subarrays With Majority Element II

import java.util.HashMap;
import java.util.Map;

public class Solution3739 {
    // 众数

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nums[i] == target ? 1 : -1;
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        // f用来表示<presum的数有多少个
        long ans = 0, presum = 0, f = 0;
        // 利用前缀和每次变化量只有1的性质
        for (int num : a) {
            if (num == 1) {
                f += cnt.getOrDefault(presum, 0);
                presum += 1;
            } else {
                presum -= 1;
                f -= cnt.getOrDefault(presum, 0);
            }
            cnt.merge(presum, 1, Integer::sum);
            ans += f;
        }

        return ans;
    }
}
