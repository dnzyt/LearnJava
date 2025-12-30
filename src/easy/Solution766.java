package easy;

// 766. Toeplitz Matrix

public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (i + k + 1 < n && k + 1 < m) {
                if (matrix[k][i + k] == matrix[k + 1][i + k + 1])
                    k++;
                else
                    return false;
            }
        }
        for (int i = 0; i < m; i++) {
            int k = 0;
            while (i + k + 1 < m && k + 1 < n) {
                if (matrix[i + k][k] == matrix[i + k + 1][k + 1])
                    k++;
                else
                    return false;
            }
        }
        return true;
    }
}
