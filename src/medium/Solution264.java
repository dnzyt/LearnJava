package medium;

// 264. Ugly Number II

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = dp[i2] * 2;
            int b = dp[i3] * 3;
            int c = dp[i5] * 5;
            int curr = Math.min(a, Math.min(b, c));
            if (curr == a)
                i2++;
            if (curr == b)
                i3++;
            if (curr == c)
                i5++;
            dp[i] = curr;
        }
        return dp[n];
    }
}
