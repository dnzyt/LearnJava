package medium;

// 2815. Max Pair Sum in an Array

import java.util.HashMap;
import java.util.Map;

public class Solution2815 {
    public int maxSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int curr = num;
            int digit = 0;
            while (curr != 0) {
                digit = Math.max(digit, curr % 10);
                curr /= 10;
            }
            if (map.containsKey(digit))
                ans = Math.max(ans, map.get(digit) + num);
            map.put(digit, Math.max(map.getOrDefault(digit, 0), num));
        }

        return ans;
    }
}
