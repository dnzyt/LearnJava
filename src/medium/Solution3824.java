package medium;

// 3824. Minimum K to Reduce Array Within Limit

import java.util.Arrays;

public class Solution3824 {
    private int[] nums;
    private int n;

    public int minimumK(int[] nums) {
        this.nums = nums;
        n = nums.length;
        int mx = 0;
        for (int num : nums)
            mx = Math.max(mx, num);

        int right = (int) Math.ceil(Math.sqrt(n));
        if (mx <= right)
            return right;
        int left = right - 1;
        right = mx;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nonPositive(mid) <= (long) mid * mid)
                right = mid;
            else
                left = mid;
        }
        return right;
    }

    private long nonPositive(int k) {
        long cnt = 0;
        for (int num : nums) {
            cnt += (num - 1) / k;
        }
        return cnt + n;
    }
}
