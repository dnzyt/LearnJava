package medium;

// 50. Pow(x, n)

public class Solution50 {
    public double myPow(double x, int n) {
        double ans = 1;
        long nn = n;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        while (nn > 0) {
            if ((nn & 1) > 0) {
                ans *= x;
            }
            x *= x;
            nn >>= 1;
        }
        return ans;
    }
}
