package hard;

// 4059. Lexicographically Largest Power Array

import java.util.Arrays;

public class Solution4059 {
    public int[] largestPower(int[] nums) {
        int[] ans = new int[15];
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < 15; i++) {
            int j = n - 1;
            while (j >= 0 && (nums[j] & (1 << (14 - i))) > 0)
                j--;
            ans[i] = n - 1 - j;
            int mask = ~(1 << (14 - i));
            while (j >= 0) {
                nums[j] &= mask;
                j--;
            }
            Arrays.sort(nums);
        }

        return ans;
    }
}
