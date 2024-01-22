package medium;

// 300. Longest Increasing Subsequence

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        int[] temp = new int[n];
        Arrays.fill(temp, Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) {
            int idx = lowerBound(temp, nums[i]);
            res[i] = idx + 1;
            temp[idx] = Math.min(temp[idx], nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int v : res)
            ans = Math.max(ans, v);
        return ans;

    }

    private int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    private int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
