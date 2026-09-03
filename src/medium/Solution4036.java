package medium;

// 4036. Lexicographically Largest String After Pair Transformations

public class Solution4036 {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf('z').repeat(nums[i] >> 25));
            for (int j = Math.min(24, 31 - Integer.numberOfLeadingZeros(nums[i])); j >= 0; j--) {
                if (((nums[i] >> j) & 1) > 0) {
                    sb.append((char) ('a' + j));
                }
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}
