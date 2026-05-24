package medium;

// 486. Predict the Winner

public class Solution486 {
    public boolean predictTheWinner(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int n = nums.length;
        int a = dfs(nums, 0, n - 1);
        return a >= sum - a;
    }

    private int dfs(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];
        if (l + 1 == r)
            return Math.max(nums[l], nums[r]);
        int a = nums[l] + Math.min(dfs(nums, l + 2, r), dfs(nums, l + 1, r - 1));
        int b = nums[r] + Math.min(dfs(nums, l, r - 2), dfs(nums, l + 1, r - 1));
        return Math.max(a, b);
    }

    public boolean predictTheWinner2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i][i] = nums[i];
            if (i + 1 < n)
                dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int a = nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                int b = nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
                dp[i][j] = Math.max(a, b);
            }
        }
        return dp[0][n - 1] >= sum - dp[0][n - 1];
    }
}
