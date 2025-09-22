package medium;

// 2260. Minimum Consecutive Cards to Pick Up

import java.util.HashMap;
import java.util.Map;

public class Solution2260 {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(cards[i])) {
                ans = Math.min(ans, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
