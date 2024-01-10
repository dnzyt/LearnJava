package medium;

// 525. Contiguous Array

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution525 {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        int[] presum = new int[n];
        int t = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1);
        for (int i = 0; i < n; i++) {
            t = t + nums[i];
            presum[i] = t;
            if (!m.containsKey(t))
                m.put(t, i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, i - m.get(presum[i]));
        }
        return res;
    }

}
