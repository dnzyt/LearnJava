package hard;

// 2338. Count the Number of Ideal Arrays

import java.util.ArrayList;
import java.util.List;

public class Solution2338 {

    private static boolean initialized;
    private static final int MX = 10000;
    private static final int MXK = 13;
    private static List<Integer>[] primes;
    private static int[][] C;

    private static final int MOD = 1000000007;

    public Solution2338() {
        if (initialized)
            return;
        initialized = true;
        primes = new List[MX + 1];
        for (int i = 2; i <= MX; i++)
            primes[i] = numOfPrime(i);

        C = new int[MX + MXK][MXK + 1];
        C[0][0] = C[1][0] = C[1][1] = 1;
        for (int i = 2; i < MX + MXK; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MXK); j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 1l;
        for (int i = 2; i <= maxValue; i++) {
            long mul = 1;
            for (int k : primes[i])
                mul = (mul * C[n + k - 1][k]) % MOD;
            ans = (ans + mul) % MOD;
        }
        return (int) ans;
    }

    private List<Integer> numOfPrime(int n) {
        List<Integer> ans = new ArrayList<>();
        int p = 2;
        while (p * p <= n) {
            int cnt = 0;
            while (n % p == 0) {
                cnt++;
                n /= p;
            }
            ans.add(cnt);
            p++;
        }
        if (n > 1)
            ans.add(1);
        return ans;
    }
}
