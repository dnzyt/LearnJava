package medium;

// 50. Pow(x, n)

public class Solution50 {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / power(x, - (long) n);
        return power(x, n);
    }

    private double power(double x, long n) {
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) > 0)
                ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }
}
