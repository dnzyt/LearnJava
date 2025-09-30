package medium;

// 1524. Number of Sub-arrays With Odd Sum

import java.util.HashMap;
import java.util.Map;

public class Solution1524 {
    private static final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : arr) {
            sum += num;
            ans += cnt.getOrDefault((sum + 1) % 2, 0) % MOD;
            ans %= MOD;
            cnt.merge(sum % 2, 1, Integer::sum);
        }
        return ans;
    }
}
