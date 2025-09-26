package medium;

// 3583. Count Special Triplets

import java.util.HashMap;
import java.util.Map;

public class Solution3583 {
    private static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> cnt = new HashMap<>();
        long[] pre = new long[n];
        for (int i = 0; i < n; i++) {
            pre[i] = cnt.getOrDefault(nums[i] * 2, 0L);
            cnt.merge(nums[i], 1L, Long::sum);
        }
        long[] suf = new long[n];
        cnt.clear();
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = cnt.getOrDefault(nums[i] * 2, 0L);
            cnt.merge(nums[i], 1L, Long::sum);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += (pre[i] * suf[i]) % MOD;
            ans %= MOD;
        }
        return ans;
    }

    // 枚举中间j
    public int specialTriplets2(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> suf = new HashMap<>();
        for (int num : nums)
            suf.merge(num, 1L, Long::sum);
        Map<Integer, Long> pre = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            suf.merge(nums[i], -1L, Long::sum);
            ans += (int) (pre.getOrDefault(nums[i] * 2, 0L) * suf.getOrDefault(nums[i] * 2, 0L) % MOD);
            pre.merge(nums[i], 1L, Long::sum);
            ans %= MOD;
        }
        return ans;
    }

    //枚举右(k),维护左(i, j)
    public int specialTriplets3(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> cnt1 = new HashMap<>();
        Map<Integer, Long> cnt12 = new HashMap<>();
        Long ans = 0L;
        for (int num : nums) {
            if (num % 2 == 0)
                ans += cnt12.getOrDefault(num / 2, 0L);
            cnt12.merge(num, cnt1.getOrDefault(num * 2, 0L), Long::sum);
            cnt1.merge(num, 1L, Long::sum);
        }

        return (int) (ans % MOD);

    }
}
