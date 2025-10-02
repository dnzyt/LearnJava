package medium;

// 525. Contiguous Array

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    // 前缀和 + hash
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) nums[i] = -1;
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, -1);
        int ans = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (cnt.containsKey(sum))
                ans = Math.max(ans, i - cnt.get(sum));
            else
                cnt.put(sum, i);
        }
        return ans;
    }

}
