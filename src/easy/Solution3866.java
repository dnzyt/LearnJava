package easy;

// 3866. First Unique Even Element

import java.util.HashMap;
import java.util.Map;

public class Solution3866 {
    public int firstUniqueEven(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        for (int num : nums) {
            if (num % 2 == 0 && cnt.get(num) == 1)
                return num;
        }
        return -1;
    }
}
