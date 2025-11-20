package hard;

// 3624. Number of Integers With Popcount-Depth Equal to K II

import util.FenwickTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3624 {
    public int[] popcountDepth(long[] nums, long[][] queries) {
        FenwickTree[] f = new FenwickTree[6];
        int n = nums.length;
        for (int i = 0; i < f.length; i++)
            f[i] = new FenwickTree(n + 1);
        for (int i = 0; i < n; i++) {
            int pc = countDepth(nums[i]);
            f[pc].update(i + 1, 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (long[] q : queries) {
            if (q[0] == 1) {
                int l = (int) q[1] + 1, r = (int) q[2] + 1, k = (int) q[3];
                ans.add(f[k].query(r) - f[k].query(l - 1));
            } else {
                int idx = (int) q[1];
                long prev = nums[idx];
                int prevpc = countDepth(prev);
                f[prevpc].update(idx + 1, -1);
                long val = q[2];
                nums[idx] = val;
                int pc = countDepth(val);
                f[pc].update(idx + 1, 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int countDepth(long x) {
        if (x == 1)
            return 0;
        return 1 + countDepth(Long.bitCount(x));
    }
}
