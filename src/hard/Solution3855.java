package hard;

// 3855. Sum of K-Digit Numbers in a Range

public class Solution3855 {
    private static final int MOD = 1000000007;

    // 贡献法 + 逆元
    public int sumOfNumbers(int l, int r, int k) {
        int m = r - l + 1;
        return (int) ((l + r) * m * (pow(10, k, MOD) - 1 + MOD) % MOD * pow(18, MOD - 2, MOD) % MOD * pow(m, k - 1, MOD) % MOD);
    }

    private long pow(long x, int n, int mod) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) > 0)
                ans = (ans * x) % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return ans;
    }
}
