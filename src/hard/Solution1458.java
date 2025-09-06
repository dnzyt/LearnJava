package hard;

// 1458. Max Dot Product of Two Subsequences

import java.util.Arrays;

public class Solution1458 {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m + 1][n + 1];
        for (int[] row : f) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = Math.max(Math.max(f[i][j + 1], f[i + 1][j]), Math.max(0, f[i][j]) + nums1[i] * nums2[j]);
            }
        }

        return f[m][n];
    }


}
