package medium;

// 2320. Count Number of Ways to Place Houses

import java.util.TreeMap;

public class Solution2320 {
    private static final long MOD = 1000000007L;

    public int countHousePlacements(int n) {

        long[] f1 = new long[]{1L, 1L, 1L, 1L};
        for (int i = 1; i < n; i++) {
            long[] newf = new long[]{
                    (f1[0] + f1[1] + f1[2] + f1[3]) % MOD,
                    (f1[0] + f1[2]) % MOD,
                    (f1[0] + f1[1]) % MOD,
                    f1[0] % MOD
            };
            f1 = newf;
        }
        return (int) ((f1[0] + f1[1] + f1[2] + f1[3]) % MOD);
    }
}
