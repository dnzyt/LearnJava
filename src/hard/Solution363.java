package hard;

// 363. Max Sum of Rectangle No Larger Than K

import java.util.Arrays;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;


        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] totals = new int[n];
            for (int t = i; t < m; t++) {
                for (int j = 0; j < n; j++)
                    totals[j] += matrix[t][j];

                int[] presum = new int[n + 1];

                for (int j = 0; j < n; j++) {
                    presum[j + 1] = presum[j] + totals[j];
                    Arrays.sort(presum, 0, j + 1);
                    int idx = lowerBound(presum, 0, j, presum[j + 1] - k);
                    if (idx == j + 1 || idx < 0)
                        continue;
                    res = Math.max(res, presum[j + 1] - presum[idx]);

                }

            }

        }
        return res;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
