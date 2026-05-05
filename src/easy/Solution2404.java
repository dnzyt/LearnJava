package easy;

// 2404. Most Frequent Even Element

import java.util.HashMap;
import java.util.Map;

public class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            if ((num & 1) != 0)
                continue;
            int c = cnt.merge(num, 1, Integer::sum);
            if (ans == -1 || cnt.get(ans) < c || cnt.get(ans) == c && ans > num)
                ans = num;
        }
        return ans;
    }
}
