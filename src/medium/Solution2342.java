package medium;

// 2342. Max Sum of a Pair With Equal Sum of Digits

import java.util.HashMap;
import java.util.Map;

public class Solution2342 {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int sum = 0;
            int curr = num;
            while (curr != 0) {
                sum += (curr % 10);
                curr /= 10;
            }
            if (map.containsKey(sum)) {
                ans = Math.max(ans, map.get(sum) + num);
            }
            map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
        }

        return ans;
    }
}
