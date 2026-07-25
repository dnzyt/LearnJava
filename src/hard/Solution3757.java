package hard;

// 3757. Number of Effective Subsequences

public class Solution3757 {

    private static boolean initialized;
    private static int[] pow2;
    private static int MX = 100001;
    private static int MOD = 1000000007;

    public Solution3757() {
        if (initialized)
            return;
        initialized = true;
        pow2 = new int[MX];
        pow2[0] = 1;
        for (int i = 1; i < MX; i++)
            pow2[i] = pow2[i - 1] * 2 % MOD;
    }

    public int countEffective(int[] nums) {
        int allOr = 0;
        boolean same = true;
        for (int num : nums) {
            allOr |= num;
            if (num != nums[0])
                same = false;
        }
        if (same)
            return 1;
        int u = 32 - Integer.numberOfLeadingZeros(allOr);
        int[] f = new int[1 << u];
        for (int num : nums)
            f[num]++;
        for (int i = 0; i < u; i++) {
            int bit = 1 << i;
            if ((allOr & bit) == 0)
                continue;
            for (int s = 0; s < 1 << u; s++) {
                s |= bit;
                f[s] += f[s ^ bit];
            }
        }
        long ans = pow2[nums.length];
        int subSet = allOr;
        while (true) {
            int p = pow2[f[subSet]];
            ans -= Integer.bitCount(subSet ^ allOr) % 2 == 0 ? p : -p;
            if (subSet == 0)
                break;
            subSet = (subSet - 1) & allOr;
        }
        return (int) ((ans % MOD + MOD) % MOD);
    }
}
