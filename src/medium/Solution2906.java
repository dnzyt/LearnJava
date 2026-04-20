package medium;

// 2906. Construct Product Matrix

public class Solution2906 {
    private static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] p = new int[m][n];
        long suf = 1l;
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                p[i][j] = (int) suf;
                suf = suf * grid[i][j] % MOD;
            }
        long pre = 1l;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                p[i][j] = (int) (p[i][j] * pre % MOD);
                pre = pre * grid[i][j] % MOD;
            }
        return p;
    }
}
