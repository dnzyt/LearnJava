package medium;

// 3719. Longest Balanced Subarray I

import util.LazySegmentTree;

import java.util.HashMap;
import java.util.Map;

public class Solution3719 {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        LazySegmentTree t = new LazySegmentTree(n + 1);
        int ans = 0, presum = 0;
        Map<Integer, Integer> last = new HashMap<>();
        // 线段树维护的是前缀和数组的值
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            int v = x % 2 == 0 ? -1 : 1;
            Integer j = last.get(x);
            if (j == null) {
                presum += v;
                t.update(i, n, v);

            } else {
                t.update(j, i - 1, -v);
            }
            last.put(x, i);
            int idx = t.findFirst(0, i - 1 - ans, presum);
            if (idx != -1)
                ans = Math.max(ans, i - idx);
        }
        return ans;
    }
}
