package easy;

// 441. Arranging Coins

public class Solution441 {
    // 二分
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        while (l <= r) {
            long mid = (l + r) >>> 1;
            if (((1 + mid) * mid) / 2 <= n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return (int) r;
    }
}