package util;

public class GCD {
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private int gcd(int x, int y) {
        while (y > 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }


    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
