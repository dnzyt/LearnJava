package medium;

// 3756. Concatenate Non-Zero Digits and Multiply by Sum II

public class Solution3756 {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_N = 100_001;
    private static final int[] pow10 = new int[MAX_N];
    private static boolean initialized = false;

    // 这样写比 static block 快
    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        // 预处理 10 的幂
        pow10[0] = 1;
        for (int i = 1; i < MAX_N; i++) {
            pow10[i] = (int) (pow10[i - 1] * 10L % MOD);
        }
    }


    public int[] sumAndMultiply(String s, int[][] queries) {
        init();

        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.charAt(i) - '0';

        int[] presum = new int[n + 1];
        int[] prenum = new int[n + 1];
        int[] precount = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
            if (nums[i] == 0) {
                prenum[i + 1] = prenum[i];
                precount[i + 1] = precount[i];
            } else {
                prenum[i + 1] = (int) ((prenum[i] * 10L + nums[i]) % MOD);
                precount[i + 1] = precount[i] + 1;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1] + 1;
            int sum = presum[r] - presum[l];
            long x = prenum[r] - (long) prenum[l] * pow10[precount[r] - precount[l]] % MOD + MOD;
            ans[i] = (int) (sum * x % MOD);
        }
        return ans;
    }
}
