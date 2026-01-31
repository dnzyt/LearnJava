package medium;

// 1594. Maximum Non Negative Product in a Matrix

public class Solution1594 {
    private static final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        long[] mnDp = new long[n];
        long[] mxDp = new long[n];
        mnDp[0] = mxDp[0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            mnDp[j] = mnDp[j - 1] * grid[0][j];
            mxDp[j] = mxDp[j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            long a = Math.min(mnDp[0] * grid[i][0], mxDp[0] * grid[i][0]);
            long b = Math.max(mnDp[0] * grid[i][0], mxDp[0] * grid[i][0]);
            mnDp[0] = a;
            mxDp[0] = b;
            for (int j = 1; j < n; j++) {
                int x = grid[i][j];
                a = Math.min(
                        Math.min(mnDp[j] * x, mxDp[j] * x),
                        Math.min(mnDp[j - 1] * x, mxDp[j - 1] * x)
                );
                b = Math.max(
                        Math.max(mnDp[j] * x, mxDp[j] * x),
                        Math.max(mnDp[j - 1] * x, mxDp[j - 1] * x)
                );
                mnDp[j] = a;
                mxDp[j] = b;
            }
        }
        return (int) (mxDp[n - 1] < 0 ? -1 : mxDp[n - 1] % MOD);
    }
}
