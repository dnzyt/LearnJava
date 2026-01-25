package easy;

// 70. Climbing Stairs

import java.util.Arrays;

public class Solution70 {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
        return memo[n];
    }

    public int climbStairs2(int n) {
        int[] f = new int[n + 2];
        Arrays.fill(f, 0);
        f[1] = 1;
        for (int i = 0; i < n; i++) {
            f[i + 2] = f[i + 1] + f[i];
        }
        return f[n + 1];
    }

    // f[n] = m * f[n-1] = m^n * f[0]
    public int climbStairs3(int n) {
        int[][] f0 = new int[][]{{1}, {0}};
        int[][] m = new int[][]{{1, 1}, {1, 0}};
        int[][] fn = matrixMul(matrixPow(m, n), f0);
        return fn[0][0];
    }


    // 矩阵快速幂
    private int[][] matrixPow(int[][] a, int n) {
        int l = a.length;
        int[][] res = new int[l][l];
        for (int i = 0; i < l; i++)
            res[i][i] = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = matrixMul(res, a);
            }
            a = matrixMul(a, a);
            n >>= 1;
        }
        return res;
    }

    private int[][] matrixMul(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[i].length; k++) {
                if (a[i][k] == 0)
                    continue;
                for (int j = 0; j < b[k].length; j++)
                    res[i][j] += a[i][k] * b[k][j];
            }
        }
        return res;
    }
}

