package medium;

// 1679. Max Number of K-Sum Pairs

import java.util.HashMap;
import java.util.Map;

public class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map.containsKey(k - key))
                ans += Math.min(map.get(key), map.get(k - key));
        }
        return ans / 2;
    }
}
