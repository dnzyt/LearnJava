package hard;

// 4. Median of Two Sorted Arrays

import java.util.Arrays;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] t = nums1;
            nums1 = nums2;
            nums2 = t;
        }

        int m = nums1.length, n = nums2.length;
        int leftTotal = (m + n + 1) / 2;


        // 开区间二分
        int left = -1, right = m;
        while (left + 1 < right) {
            int i = (left + right) >>> 1;
            int j = leftTotal - i - 2;

            if (nums1[i] <= nums2[j + 1])
                left = i;
            else
                right = i;
        }

        int i = left;
        int j = leftTotal - i - 2;

        int ai = i < 0 ? Integer.MIN_VALUE : nums1[i];
        int bj = j < 0 ? Integer.MIN_VALUE : nums2[j];
        int ai1 = i + 1 == m ? Integer.MAX_VALUE : nums1[i + 1];
        int bj1 = j + 1 == n ? Integer.MAX_VALUE : nums2[j + 1];


        int max1 = Math.max(ai, bj);
        int min2 = Math.min(ai1, bj1);

        return (m + n) % 2 == 0 ? (max1 + min2) / 2.0 : max1;
    }

}
/*
j + 1 = leftTotal - (i + 1)


 */