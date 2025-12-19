package medium;

// 3766. Minimum Operations to Make Binary Palindrome

public class Solution3766 {
    public int[] minOperations(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int res = Integer.MAX_VALUE;
            int n = 32 - Integer.numberOfLeadingZeros(nums[i]);
            int m = n / 2;
            int left = nums[i] >> m;
            for (int l = left - 1; l < left + 2; l++) {
                int r = Integer.reverse(l >> (n % 2)) >>> (32 - m);
                int pal = l << m | r;
                res = Math.min(res, Math.abs(nums[i] - pal));
            }
            nums[i] = res;
        }
        return nums;
    }
}
