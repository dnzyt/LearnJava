package hard;

// 3171. Find Subarray With Bitwise OR Closest to K

public class Solution3171 {
    // LogTrick
    public int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            res = Math.min(res, Math.abs(nums[j] - k));
            // 内层循环不会超过30次
            for (int i = j - 1; i >= 0; i--) {
                if ((nums[i] | nums[j]) == nums[i])
                    break;
                nums[i] |= nums[j];
                res = Math.min(res, Math.abs(nums[i] - k));
            }
        }
        return res;
    }
}
