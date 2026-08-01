package medium;

// 4002. Count Valid Sequences

public class Solution4002 {

    private static int MOD = 1_000_000_007;
    private static int MX = 500001;
    private static long[] F = new long[MX];
    private static long[] INV_F = new long[MX];

    private static boolean initialized = false;

    public Solution4002() {
        if (initialized)
            return;
        initialized = true;
        F[0] = 1;
        for (int i = 1; i < MX; i++)
            F[i] = F[i - 1] * i % MOD;
        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--)
            INV_F[i - 1] = INV_F[i] * i % MOD;
    }

    private long pow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 > 0)
                res = res * x % MOD;
            x = x * x % MOD;
            n /= 2;
        }
        return res;
    }

    private long comb(int n, int m) {
        return (m < 0 || n < m) ? 0 : F[n] * INV_F[m] % MOD * INV_F[n - m] % MOD;
    }


    public int countValidSequences(int n, int k) {
        long res = comb(n - 1, k - 1);
        if ((n + k) % 2 == 0)
            res = (res - comb((n + k) / 2 - 1, k - 1) + MOD) % MOD;
        return (int) res;
    }
}
