package easy;

// 2357. Make Array Zero by Subtracting Equal Amounts

import java.util.HashSet;
import java.util.Set;

public class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (num != 0)
                s.add(num);
        }
        return s.size();
    }
}
