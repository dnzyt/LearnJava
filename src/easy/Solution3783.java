package easy;

// 3783. Mirror Distance of an Integer

public class Solution3783 {
    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans *= 10;
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }


    public int mirrorDistance2(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int a = Integer.parseInt(sb.toString());
        return Math.abs(n - a);
    }
}
