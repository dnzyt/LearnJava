package medium;

// 2948. Make Lexicographically Smallest Array by Swapping Elements

import java.util.Arrays;

public class Solution2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++)
            pos[i] = i;
        Arrays.sort(pos, (i, j) -> nums[i] - nums[j]);
        int[] ans = new int[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || nums[pos[i + 1]] - nums[pos[i]] > limit) {
                Integer[] subPos = Arrays.copyOfRange(pos, start, i + 1);
                Arrays.sort(subPos);
                for (int j = 0; j < subPos.length; j++) {
                    ans[subPos[j]] = nums[pos[start + j]];
                }
                start = i + 1;
            }
        }
        return ans;
    }
}
