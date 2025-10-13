package medium;

// 2419. Longest Subarray With Maximum Bitwise AND

public class Solution2419 {
    public int longestSubarray(int[] nums) {
        int mx = 0;
        for (int num : nums)
            mx = Math.max(mx, num);
        int count = 0, res = 0;
        for (int num : nums) {
            if (num == mx) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
