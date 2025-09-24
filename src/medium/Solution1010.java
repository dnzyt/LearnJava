package medium;

// 1010. Pairs of Songs With Total Durations Divisible by 60

import java.util.HashMap;
import java.util.Map;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : time) {
            int r = t % 60;
            if (map.containsKey((60 - r) % 60))
                ans += map.get((60 - r) % 60);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        return ans;
    }
}
