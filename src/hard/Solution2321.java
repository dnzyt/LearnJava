package hard;

public class Solution2321 {
    // 最大子数组和的变形, kadane算法
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
            diff[i] = nums1[i] - nums2[i];
        }
        int maxf = diff[0], res1 = diff[0];
        int minf = diff[0], res2 = diff[0];
        for (int i = 1; i < n; i++) {
            maxf = Math.max(0, maxf) + diff[i];
            res1 = Math.max(res1, maxf);
            minf = Math.min(0, minf) + diff[i];
            res2 = Math.min(res2, minf);
        }
        return Math.max(sum2 + res1, sum1 - res2);
    }
}
