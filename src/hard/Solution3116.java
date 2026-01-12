package hard;

public class Solution3116 {
    // 容斥原理：奇数个元素交为正号，偶数个元素交为负号
    public long findKthSmallest(int[] coins, int k) {
        int minCoin = Integer.MAX_VALUE;
        for (int coin : coins)
            minCoin = Math.min(minCoin, coin);
        long l = (long) k - 1;
        long r = (long) k * minCoin;

        while (l + 1 < r) {
            long mid = (l + r) >>> 1;
            if (check(mid, coins, k))
                r = mid;
            else
                l = mid;
        }
        return r;
    }


    private boolean check(long m, int[] coins, int k) {
        int n = coins.length;
        long ans = 0L;
        for (int i = 1; i < (1 << n); i++) {
            long lcmRes = 1L;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) > 0) {
                    lcmRes = lcm(lcmRes, coins[j]);
                }
            }
            long x = m / lcmRes;
            ans += Integer.bitCount(i) % 2 == 0 ? -x : x;
        }
        return ans >= k;
    }

    private long gcd(long x, long y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

    private long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}
