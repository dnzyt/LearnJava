package medium;

// 3693. Climbing Stairs II

public class Solution3693 {
    public int climbStairs(int n, int[] costs) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = i - 1; j >= Math.max(i - 3, 0); j--) {
                res = Math.min(res, f[j] + (i - j) * (i - j));
            }
            f[i] = res + costs[i - 1];
        }
        return f[n];
    }
}
