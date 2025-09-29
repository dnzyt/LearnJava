package easy;

// 3427. Sum of Variable Length Subarrays

public class Solution3427 {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + nums[i];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - nums[i]);
            ans += s[i + 1] - s[left];
        }
        return ans;
    }
}
