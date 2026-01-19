package medium;

// 3810. Minimum Operations to Reach Target Array

import java.util.HashSet;
import java.util.Set;

public class Solution3810 {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target[i])
                continue;
            s.add(nums[i]);
        }
        return s.size();
    }
}
