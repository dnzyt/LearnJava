package medium;

public class Solution2874 {
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
}
