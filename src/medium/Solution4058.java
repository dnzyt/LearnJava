package medium;

// 4058. Maximum Pulse Value After One Subarray Rotation

import java.util.Arrays;

public class Solution4058 {
    public long maxValue(int[] nums) {
        long sum = 0L;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += i % 2 == 0 ? nums[i] : -nums[i];
        }

        long[] f = new long[n + 1];
        long mx = 0L;
        for (int i = 1; i < n; i++) {
            int d = nums[i] - nums[i - 1];
            f[i + 1] = Math.max(f[i - 1], 0) + (i % 2 > 0 ? d : -d);
            mx = Math.max(mx, f[i + 1]);
        }
        return sum + 2 * mx;
    }
}
