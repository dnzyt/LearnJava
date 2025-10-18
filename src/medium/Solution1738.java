package medium;

// 1738. Find Kth Largest XOR Coordinate Value

import java.util.Arrays;

public class Solution1738 {
    // 二维前缀异或和
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        int[] ans = new int[m * n];
        int idx = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = f[i][j + 1] ^ f[i + 1][j] ^ f[i][j] ^ matrix[i][j];
                ans[idx++] = f[i + 1][j + 1];
            }
        Arrays.sort(ans);
        return ans[idx - k];
    }
}
