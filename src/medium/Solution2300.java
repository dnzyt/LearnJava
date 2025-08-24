package medium;

// 2300. Successful Pairs of Spells and Potions

import java.util.Arrays;

public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long target = (success + spell - 1) / spell; // 上取整
            int idx = lowerBound(potions, target);
            ans[i] = potions.length - idx;
        }

        return ans;
    }

    private int lowerBound(int[] nums, long target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
