package easy;

// 1512. Number of Good Pairs

import java.util.HashMap;
import java.util.Map;

public class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            if (map.containsKey(num)) {
                ans += map.get(num);
            }
            map.put(num, cnt + 1);
        }
        return ans;
    }
}
