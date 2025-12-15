package easy;

// 3774. Absolute Difference Between Maximum and Minimum K Elements

import java.util.Arrays;

public class Solution3774 {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return sum(nums, n - k, n) - sum(nums, 0, k);

    }

    private int sum(int[] a, int l, int r) {
        int s = 0;
        for (int i = l; i < r; i++)
            s += a[i];
        return s;
    }
}
