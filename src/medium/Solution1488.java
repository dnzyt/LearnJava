package medium;

// 1488. Avoid Flood in The City

import java.util.*;

public class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> zeroes = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (map.containsKey(rains[i])) {
                    int idx = map.get(rains[i]);
                    Integer dry = zeroes.higher(idx);
                    if (dry == null)
                        return new int[]{};
                    ans[dry] = rains[idx];
                    zeroes.remove(dry);
                    map.put(rains[i], i);
                } else {
                    map.put(rains[i], i);
                }
            } else {
                zeroes.add(i);
                ans[i] = 1;
            }

        }
        return ans;
    }
}
