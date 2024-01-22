package hard;

// 4. Median of Two Sorted Arrays

import java.util.Arrays;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        if ((l1 + l2) % 2 == 1)
            return findKthElement(nums1, nums2, 1 + (l1 + l2) / 2);
        else
            return (
                    findKthElement(nums1, nums2, (l1 + l2) / 2) +
                            findKthElement(nums1, nums2, 1 + (l1 + l2) / 2)
            ) / 2.0;
    }

    private int findKthElement(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        if (l1 > l2)
            return findKthElement(nums2, nums1, k);
        if (l1 == 0)
            return nums2[k - 1];
        if (k == 1)
            return Math.min(nums1[0], nums2[0]);


        int p1 = k / 2;
        if (p1 > l1)
            p1 = l1;
        int p2 = k - p1;
        if (nums1[p1 - 1] < nums2[p2 - 1])
            return findKthElement(Arrays.copyOfRange(nums1, p1, l1), nums2, k - p1);
        else
            return findKthElement(nums1, Arrays.copyOfRange(nums2, p2, l2), k - p2);
    }
}

/*
XXXX X0 XXX

YYYYYY Y0 YYYYYYY

if nums1[x0] < nums2[y0]: 那么x0及其左边都不可能是第k个元素
else: 那么y0及其左边都不可能是第k个元素

 */