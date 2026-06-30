package medium;

// 3737. Count Subarrays With Majority Element I

public class Solution3737 {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] presum = new int[n + 1];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target)
                cnt++;
            presum[i + 1] = cnt;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 < (presum[j + 1] - presum[i]) * 2)
                    ans++;
            }
        }
        return ans;
    }
}
