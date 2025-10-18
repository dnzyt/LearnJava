package medium;

public class Solution304 {

    static class NumMatrix {
        private int m;
        private int n;
        private int[][] f;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            f = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    f[i + 1][j + 1] = f[i][j + 1] + f[i + 1][j] - f[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return f[row2 + 1][col2 + 1] - f[row1][col2 + 1] - f[row2 + 1][col1] + f[row1][col1];
        }
    }

}


