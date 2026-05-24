package easy;

// 2540. Minimum Common Value

public class Solution2540 {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])
                return nums1[i];
            if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        if (i < nums1.length) {
            if (nums1[i] == nums2[j - 1])
                return nums2[j - 1];
            i++;
        }
        if (j < nums2.length) {
            if (nums2[j] == nums1[i - 1])
                return nums1[i - 1];
            j++;
        }
        return -1;
    }
}
