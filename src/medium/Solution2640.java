package medium;

// 2640. Find the Score of All Prefixes of an Array

public class Solution2640 {

    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] conv = new long[n];
        long biggest = -1;
        for (int i = 0; i < n; i++) {
            biggest = Math.max(biggest, nums[i]);
            conv[i] = nums[i] + biggest;
        }

        long[] ans = new long[n];
        long acc = 0;
        for (int i = 0; i < n; i++) {
            ans[i] = acc + conv[i];
            acc += conv[i];
        }
        return ans;
    }
}
