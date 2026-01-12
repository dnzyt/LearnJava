package medium;

// 2411. Smallest Subarrays With Maximum Bitwise OR

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Solution2411 {
    // LogTrick
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            ans[j] = 1;
            for (int i = j - 1; i >= 0; i--) { // 内层循环不会超过30次
                if ((nums[i] | nums[j]) == nums[i]) break;
                nums[i] |= nums[j];
                ans[i] = j - i + 1;
            }
        }
        return ans;
    }
}
