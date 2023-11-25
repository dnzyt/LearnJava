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
            int idx = Arrays.binarySearch(temp, nums[i]);
            idx = idx < 0 ? (~idx) : idx;
            res[i] = idx + 1;
            temp[idx] = Math.min(temp[idx], nums[i]);
        }

        return Arrays.stream(res).max().orElseThrow();
    }
}
