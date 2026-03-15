package easy;

// 2834. Find the Minimum Possible Sum of a Beautiful Array

public class Solution2834 {
    private static final int MOD = 1000000007;

    public int minimumPossibleSum(int n, int target) {
        long m = Math.min(n, target / 2);
        return (int) ((((1 + m) * m + (target * 2 + (n - m) - 1) * (n - m)) / 2) % MOD);
    }
}
