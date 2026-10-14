package hard;

// 2897. Apply Operations on Array to Maximize Sum of Squares

import java.util.List;

public class Solution2897 {
    private static final int MOD = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++)
                count[i] += (num >> i) & 1;
        }
        long ans = 0L;
        for (int i = 0; i < k; k++) {
            long x = 0;
            for (int j = 0; j < 32; j++) {
                if (count[j] > 0) {
                    x += (1 << j);
                    count[j]--;
                }
            }
            ans += x * x;
            ans %= MOD;
        }
        return (int) ans;
    }
}
