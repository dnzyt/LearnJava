package medium;

// 2787. Ways to Express an Integer as Sum of Powers

public class Solution2787 {
    private static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int v = (int) Math.pow(i, x);
            for (int j = n; j - v >= 0; j--)
                f[j] += f[j - v];
        }
        return (int) (f[n] % MOD);
    }
}
