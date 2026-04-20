package easy;

// 1137. N-th Tribonacci Number

public class Solution1137 {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        int[][] start = {{1, 1, 0}};
        int[][] base = {
                {1, 1, 0},
                {1, 0, 1},
                {1, 0, 0}
        };
        int[][] ans = multiply(start, power(base, n - 2));
        return ans[0][0];
    }

    // 矩阵乘法
    private int[][] multiply(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int k = a[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int c = 0; c < k; c++)
                    ans[i][j] += a[i][c] * b[c][j];
        return ans;
    }

    // 矩阵快速幂
    private int[][] power(int[][] matrix, int p) {
        int m = matrix.length;
        int[][] ans = new int[m][m];
        for (int i = 0; i < m; i++)
            ans[i][i] = 1;
        while (p > 0) {
            if ((p & 1) > 0) {
                ans = multiply(ans, matrix);
            }
            matrix = multiply(matrix, matrix);
            p >>= 1;
        }
        return ans;
    }
}
