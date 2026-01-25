package medium;

// 1186. Maximum Subarray Sum with One Deletion

public class Solution1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + arr[i];
            res = Math.max(res, dp[i]);
        }
        int revMax = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (i - 1 >= 0)
                res = Math.max(res, dp[i - 1] + revMax);
            revMax = Math.max(revMax, 0) + arr[i];
        }
        return res;
    }
}
