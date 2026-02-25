package medium;

// 308. Range Sum Query 2D - Mutable

public class Solution308 {

    // 二维树状数组，单点更新，区间查询
    class NumMatrix {
        private int[][] nums;
        private int[][] tree;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            nums = new int[m + 1][n + 1];
            tree = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    nums[i + 1][j + 1] = matrix[i][j];
                    add(i + 1, j + 1, matrix[i][j]);
                }
        }

        public void update(int row, int col, int val) {
            add(row + 1, col + 1, val - nums[row + 1][col + 1]);
            nums[row + 1][col + 1] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return presum(row2 + 1, col2 + 1) - presum(row2 + 1, col1) - presum(row1, col2 + 1) + presum(row1, col1);
        }

        private void add(int row, int col, int delta) {
            for (int i = row; i < tree.length; i += lowbit(i))
                for (int j = col; j < tree[0].length; j += lowbit(j))
                    tree[i][j] += delta;
        }

        private int lowbit(int x) {
            return x & -x;
        }

        private int presum(int row, int col) {
            int res = 0;
            for (int i = row; i > 0; i -= lowbit(i))
                for (int j = col; j > 0; j -= lowbit(j))
                    res += tree[i][j];
            return res;
        }
    }

}
