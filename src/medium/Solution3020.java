package medium;

// 3020. Find the Maximum Number of Elements in Subset

import java.util.HashMap;
import java.util.Map;

public class Solution3020 {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.merge(num, 1, Integer::sum);
        int ans = cnt.getOrDefault(1, 0) - ((cnt.getOrDefault(1, 0) % 2) ^ 1);
        cnt.remove(1);
        for (int i : cnt.keySet()) {
            int x = i;
            int c = 0;
            while (cnt.containsKey(x)) {
                c++;
                if (cnt.get(x) == 1)
                    break;

                x *= x;
            }
            ans = Math.max(ans, c * 2 - 1);
        }
        return ans;
    }
}
