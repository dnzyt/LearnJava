package easy;

// 674. Longest Continuous Increasing Subsequence

public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int i = 0;
        int ans = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j - 1] >= nums[j]) {
                i = j;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
