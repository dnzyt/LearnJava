package medium;

// 396. Rotate Function

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int total = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            s += i * nums[i];
        }
        int ans = s;
        for (int i = n - 1; i >= 0; i--) {
            s = s - n * nums[i] + total;
            ans = Math.max(ans, s);
        }
        return ans;
    }
}
