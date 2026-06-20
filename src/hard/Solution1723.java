package hard;

// 1723. Find Minimum Time to Finish All Jobs

public class Solution1723 {
    // 和粉饼干那道题一样的
    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 0; i < n; i++) {
            int bit = 1 << i;
            for (int j = 0; j < bit; j++)
                sum[j | bit] = jobs[i] + sum[j];
        }

        int[][] f = new int[k][1 << n];
        f[0] = sum;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                f[i][j] = f[i - 1][j];
                for (int s = j; s > 0; s = (s - 1) & j)
                    f[i][j] = Math.min(f[i][j], Math.max(f[i - 1][j ^ s], sum[s]));
            }
        }
        return f[k - 1][(1 << n) - 1];
    }
}
