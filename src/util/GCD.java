package util;

public class GCD {
    public static long gcd(long x, long y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
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


    // 扩展欧几里得算法
    // ans[0] -> gcd
    // ans[1] -> 逆元 (a, b需互质）
    public static int[] exGcd(int a, int b) {
        int[] ans = new int[3];
        if (b == 0) {
            ans[0] = a;
            ans[1] = 1;
            ans[2] = 0;
        } else {
            ans = exGcd(b, a % b);
            int tempX = ans[1];
            int tempY = ans[2];
            ans[1] = tempY;
            ans[2] = tempX - tempY * (a / b);
        }
        return ans;
    }
}
