package easy;

// 908. Smallest Range I

public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mx = Math.max(mx, num);
            mn = Math.min(mn, num);
        }
        mx -= k;
        mn += k;
        return Math.max(mx - mn, 0);
    }
}
