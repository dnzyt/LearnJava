package medium;

// 1983. Widest Pair of Indices With Equal Range Sum

import java.util.HashMap;
import java.util.Map;

public class Solution1983 {

    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        int res = 0;
        int t1 = 0, t2 = 0;
        for (int i = 0; i < n; i++) {
            t1 += nums1[i];
            t2 += nums2[i];
            int diff = t1 - t2;
            if (m.containsKey(diff)) {
                res = Math.max(res, i - m.get(diff));
            } else {
                m.put(diff, i);
            }
        }
        return res;
    }

}
