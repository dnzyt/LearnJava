package medium;

// 4067. Longest Subarray With Restricted Pair Sums

public class Solution4067 {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] cntS = new int[1001];
        int[] cntD = new int[1001];
        int left = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (cntS[x] > 0 || cntD[x] > 0) {
                int y = nums[left];
                left++;
                for (int j = left; j < i; j++) {
                    cntS[y + nums[j]]--;
                    cntD[Math.abs(y - nums[j])]--;
                }
            }
            ans = Math.max(ans, i - left + 1);
            for (int j = left; j < i; j++) {
                cntS[nums[j] + x]++;
                cntD[Math.abs(nums[j] - x)]++;
            }
        }
        return ans;
    }
}
