package medium;

// 3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K

public class Solution3007 {
    private long k;
    private int x;

    public long findMaximumNumber(long k, int x) {
        this.k = k;
        this.x = x;
        long left = 0, right = (k + 1) << x;
        while (left + 1 < right) {
            long mid = (left + right) >>> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(long m) {
        long ans = 0L;
        for (int i = x - 1; (1L << i) <= m; i += x) {
            long currDigit = (m >> i) & 1L;
            long left = m >> (i + 1);
            long right = m & ((1L << i) - 1L);
            if (currDigit == 0L) {
                ans += left * (1L << i);
            } else {
                ans += left * (1L << i);
                ans += right + 1L;
            }
            if (ans > k)
                return false;
        }
        return ans <= k;
    }

    // 贡献法
    // 从低到高每一位上有多少1贡献给最终结果
    private boolean check2(long num) {
        int shift = x - 1;
        long n = num >> shift;
        long res = 0;
        while (n > 0) {
            // 第一部分
            res += ((n - 1) + 1) >> 1 << shift;
            if ((n & 1) > 0) {
                long mask = (1L << shift) - 1;
                res += (num & mask) + 1;
            }
            n >>= x;
            shift += x;
        }
        return res <= k;
    }


    // 试填法
    public long findMaximumNumber2(long k, int x) {
        long num = 0L;
        long pre1 = 0L;

        for (long i = 64 - Long.numberOfLeadingZeros((k + 1) << x) - 1; i >= 0; i--) {
            long cnt = (pre1 << i) + ((i / x) << (i - 1));
            if (cnt > k)
                continue;
            k -= cnt;
            num |= (1L << i);
            if ((i + 1) % x == 0)
                pre1++;
        }
        return num - 1;

    }

}
