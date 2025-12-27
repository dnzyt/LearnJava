package medium;

// 509. Fibonacci Number

public class Solution509 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int[][] f1 = new int[][]{{1}, {0}};
        int[][] m = new int[][]{{1, 1}, {1, 0}};
        int[][] fn = mulMatrix(powMul(m, n - 1), f1);

        return fn[0][0];
    }

    // 矩阵快速幂
    private int[][] powMul(int[][] a, int n) {
        int l = a.length;
        int[][] res = new int[l][l];
        for (int i = 0; i < l; i++)
            res[i][i] = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = mulMatrix(res, a);
            }
            n >>= 1;
            a = mulMatrix(a, a);
        }
        return res;
    }

    // 矩阵乘法
    private int[][] mulMatrix(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < a[i].length; k++) {
                if (a[i][k] == 0)
                    continue;
                for (int j = 0; j < n; j++)
                    res[i][j] += a[i][k] * b[k][j];
            }

        }
        return res;
    }
}

