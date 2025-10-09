package medium;

// 1685. Sum of Absolute Differences in a Sorted Array

public class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++)
            presum[i + 1] = presum[i] + nums[i];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = nums[i] * i - presum[i];
            int right = presum[n] - presum[i + 1] - (n - 1 - i) * nums[i];
            ans[i] = left + right;
        }

        return ans;
    }
}
