package easy;

// 1979. Find Greatest Common Divisor of Array

public class Solution1979 {
    public int findGCD(int[] nums) {
        int mx = 0, mn = 1001;
        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }
        return gcd(mx, mn);
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
