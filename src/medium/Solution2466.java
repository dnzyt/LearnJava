package medium;

// 2466. Count Ways To Build Good Strings

public class Solution2466 {
    private int MOD = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] f = new int[high + 1];
        f[0] = 1;
        int res = 0;
        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0)
                f[i] += f[i - zero];
            if (i - one >= 0)
                f[i] += f[i - one];
            f[i] %= MOD;
            if (i >= low)
                res += f[i];
            res %= MOD;
        }
        return res;
    }
}
