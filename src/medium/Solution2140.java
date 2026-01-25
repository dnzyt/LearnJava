package medium;

// 2140. Solving Questions With Brainpower

public class Solution2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0], bpower = questions[i][1];
            f[i] = Math.max((long) points + f[Math.min(i + bpower + 1, n)], f[i + 1]);
        }
        return f[0];
    }
}
