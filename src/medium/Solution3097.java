package medium;

// 3097. Shortest Subarray With OR at Least K II

public class Solution3097 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        for (int j = 0; j < n; j++) {
            if (nums[j] >= k) return 1;
            for (int i = j - 1; i >= 0; i--) {
                if ((nums[i] | nums[j]) == nums[i]) break;
                nums[i] |= nums[j];
                if (nums[i] >= k)
                    ans = Math.min(ans, j - i + 1);
            }
        }
        return ans == n + 1 ? -1 : ans;
    }
}
