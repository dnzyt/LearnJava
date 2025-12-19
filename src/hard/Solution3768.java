package hard;

import util.FenwickTree;

import java.util.Arrays;

public class Solution3768 {
    public long minInversionCount(int[] nums, int k) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        FenwickTree t = new FenwickTree(sorted.length);

        long inv = 0;
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int in = nums[i];
            t.update(in, 1);
            inv += Math.min(i + 1, k) - t.query(in);
            int left = i - k + 1;
            if (left < 0)
                continue;
            ans = Math.min(ans, inv);
            if (ans == 0)
                break;
            int out = nums[left];
            inv -= t.query(out - 1);
            t.update(out, -1);
        }
        return ans;
    }
}
