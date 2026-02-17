package hard;

// 2585. Number of Ways to Earn Points

public class Solution2582 {
    private static final int MOD = 1000000007;

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            int cnt = types[i][0];
            int mark = types[i][1];
            int[] cp = f.clone();
            for (int j = 1; j <= cnt; j++) {
                int currMark = j * mark;
                for (int k = currMark; k <= target; k++)
                    f[k] = (f[k] + cp[k - currMark]) % MOD;
            }
        }
        return f[target];
    }
}
