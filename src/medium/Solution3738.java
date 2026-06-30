package medium;

// 3738. Longest Non-Decreasing Subarray After Replacing at Most One Element

import java.util.Arrays;

public class Solution3738 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] <= nums[i])
                left[i] += left[i - 1];
            if (nums[n - 1 - i] <= nums[n - i])
                right[n - 1 - i] += right[n - i];
        }

        int ans = Math.max(right[1], left[n - 2]) + 1;
        for (int i = 1; i < n - 1; i++) {
            int c = 1;

            if (nums[i - 1] <= nums[i + 1])
                c += left[i - 1] + right[i + 1];
            else
                c += Math.max(left[i - 1], right[i + 1]);

            ans = Math.max(ans, c);
        }
        return ans;
    }
}
