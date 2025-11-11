package medium;

// 3618. Split Array by Prime Indices

import util.PrimeSeq;

public class Solution3618 {
    public long splitArray(int[] nums) {
        int n = nums.length;
        boolean[] s = PrimeSeq.primes(n + 1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i])
                ans -= nums[i];
            else
                ans += nums[i];
        }
        return Math.abs(ans);
    }
}
