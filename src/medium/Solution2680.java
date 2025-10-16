package medium;

// 2680. Maximum OR

public class Solution2680 {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[] l = new int[n + 1];
        int[] r = new int[n + 1];
        for (int i = 0; i < n; i++)
            l[i + 1] = l[i] | nums[i];
        for (int i = n - 1; i >= 0; i--)
            r[i] = r[i + 1] | nums[i];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long x = (long) nums[i] << k | l[i] | r[i + 1];
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
