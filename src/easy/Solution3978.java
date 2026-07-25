package easy;

// 3978. Unique Middle Element

import java.util.HashMap;
import java.util.Map;

public class Solution3978 {
    public boolean isMiddleElementUnique(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        int mid = nums[nums.length / 2];
        return cnt.get(mid) == 1;
    }
}
