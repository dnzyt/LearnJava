package medium;

// 3759. Count Elements With at Least K Greater Values

import java.util.Arrays;

public class Solution3759 {
    public int countElements(int[] nums, int k) {
        if (k == 0)
            return nums.length;
        Arrays.sort(nums);
        int kth = nums[nums.length - k];
        int idx = lowerBound(nums, kth);
        if (idx == -1)
            return 0;
        return idx + 1;
    }

    private int lowerBound(int[] nums, int v) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] < v)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return r;
    }
}
