package easy;

// 2574. Left and Right Sum Differences

public class Solution2574 {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + nums[i];
            right[n - 1 - i] = right[n - i] + nums[n - 1 - i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = Math.abs(left[i] - right[i + 1]);
        return ans;
    }
}
