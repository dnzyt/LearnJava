package hard;

// 3939. Count Non Adjacent Subsets in a Rooted Tree

public class Solution3939 {
    private static final int MOD = 1000000007;

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;
        // [index, not pick/pick, remainder]
        long[][][] cnt = new long[n][2][k];

        for (int i = 0; i < n; i++) {
            cnt[i][0][0] = 1;
            cnt[i][1][nums[i] % k] = 1;
        }

        for (int i = n - 1; i > 0; i--) {
            int p = parent[i];
            long[][] temp = new long[2][k];
            for (int j = 0; j < k; j++) {
                for (int v = 0; v < k; v++) {
                    int r = (j + v) % k;
                    temp[0][r] = (temp[0][r] + (cnt[p][0][j] * ((cnt[i][0][v] + cnt[i][1][v]) % MOD)) % MOD) % MOD;
                    temp[1][r] = (temp[1][r] + (cnt[p][1][j] * cnt[i][0][v] % MOD)) % MOD;
                }
            }
            cnt[p] = temp;
        }
        // 减1是为了去掉空集
        return (int) (((cnt[0][0][0] + cnt[0][1][0]) % MOD - 1) + MOD) % MOD;
    }
}
