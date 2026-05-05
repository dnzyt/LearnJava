package medium;

// 3919. Minimum Cost to Move Between Indices

public class Solution3919 {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] sumL = new int[n]; // moving from left to right, the cost to reach index i
        int[] sumR = new int[n]; // moving from right to left, the cost to reach index 0 from i

        for (int i = 1; i < n; i++) {
            // moving right to reach i
            if (i > 1 && Math.abs(nums[i - 1] - nums[i - 2]) <= Math.abs(nums[i] - nums[i - 1]))
                sumR[i] = sumR[i - 1] + nums[i] - nums[i - 1];
            else
                sumR[i] = sumR[i - 1] + 1;

            // moving left to reach 0 from i
            if (i < n - 1 && Math.abs(nums[i] - nums[i - 1]) > Math.abs(nums[i + 1] - nums[i]))
                sumL[i] = sumL[i - 1] + nums[i] - nums[i - 1];
            else
                sumL[i] = sumL[i - 1] + 1;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l < r) {
                ans[i] = sumR[r] - sumR[l];
            } else {
                ans[i] = sumL[l] - sumL[r];
            }
        }
        return ans;
    }
}
