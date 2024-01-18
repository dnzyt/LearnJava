package util;

public class GCD {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}
