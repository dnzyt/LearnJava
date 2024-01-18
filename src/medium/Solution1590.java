package medium;

// 1590. Make Sum Divisible by P

import java.util.HashMap;
import java.util.Map;

public class Solution1590 {
    // (total + presum[j-1])%p = presum[i]%p
    // 寻找最后一次出现相等余数的位置
    public int minSubarray(int[] nums, int p) {
        Map<Long, Integer> hash = new HashMap<>();
        long total = 0;
        for (int num : nums) total += num;
        if (total % p == 0) return 0;
        hash.put(total % p, -1);
        long presum = 0L;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            if (hash.containsKey(presum % p)) {
                int len = i - hash.get(presum % p);
                // 如果len等于数组长度，说明要把整个数组全都删除，与题意矛盾，所以排出这种情况
                res = Math.min(res, len == nums.length ? Integer.MAX_VALUE : len);
            }
            hash.put((total + presum) % p, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
