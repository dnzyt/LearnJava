package medium;

// 1191. K-Concatenation Maximum Sum

import java.util.Arrays;

public class Solution1191 {
    private static final int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        if (k == 1)
            return Math.max(0, (int) maxSum(arr));
        int n = arr.length;
        int[] twoArr = new int[n * 2];
        System.arraycopy(arr, 0, twoArr, 0, n);
        System.arraycopy(arr, 0, twoArr, n, n);
        long res = maxSum(twoArr);
        long sum = Math.max(Arrays.stream(arr).sum(), 0);
        for (int i = 0; i < k - 2; i++) {
            res += sum;
            res %= MOD;
        }
        return res > 0 ? (int) res % MOD : 0;
    }

    private long maxSum(int[] arr) {
        int n = arr.length;
        long[] dp = new long[n];
        dp[0] = arr[0];
        long res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + arr[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
