package medium;

// 2320. Count Number of Ways to Place Houses

import java.util.TreeMap;

public class Solution2320 {
    private static final int MOD = 1000000007;
    private static final int MX = 10000;
    private static boolean initialzed;
    private static int[] f;

    public Solution2320() {
        if (initialzed)
            return;
        initialzed = true;
        f = new int[MX + 1];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i <= MX; i++)
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
    }

    public int countHousePlacements(int n) {
        return (int) (((long) f[n] * f[n]) % MOD);
    }
}
