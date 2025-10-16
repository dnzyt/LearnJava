package medium;

// 2401. Longest Nice Subarray

public class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int or = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            int num = nums[j];
            while (i < j && (or & num) != 0) {
                or ^= nums[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
            or |= num;
        }

        return res;
    }
}
