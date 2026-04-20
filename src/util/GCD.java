package util;

public class GCD {
    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private int gcd(int x, int y) {
        while (x != 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }


    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
