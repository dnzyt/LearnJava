package medium;

public class Solution2874 {
    // 枚举右(k)，维护左(nums[i]-nums[j])
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long mx = 0;
        long diffMx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2) {
                ans = Math.max(ans, (long) nums[i] * diffMx);
            }
            diffMx = Math.max(diffMx, mx - (long) nums[i]);
            mx = Math.max(mx, (long) nums[i]);
        }
        return ans;
    }

    // 枚举中间j
    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        int[] rightMx = new int[n];
        rightMx[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMx[i] = Math.max(nums[i], rightMx[i + 1]);
        long ans = 0;
        int leftMx = nums[0];
        for (int j = 1; j < n - 1; j++) {
            ans = Math.max(ans, (long) (leftMx - nums[j]) * rightMx[j + 1]);
            leftMx = Math.max(leftMx, nums[j]);
        }
        return ans;
    }
}
