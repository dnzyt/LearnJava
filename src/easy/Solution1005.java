package easy;

// 1005. Maximize Sum Of Array After K Negations

import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            if (k > 0 && num < 0) {
                k--;
                num = -num;
            }
            sum += num;
            mn = Math.min(mn, num);
        }
        return sum - k % 2 > 0 ? mn * 2 : 0;
    }
}
/*
 * [2,-3,-1,5,-4]
 * -4 -3 -1 2 5
 *
 * */