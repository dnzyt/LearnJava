package medium;

// 447. Number of Boomerangs

import java.util.HashMap;
import java.util.Map;

public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] p1 : points) {
            cnt.clear();
            for (int[] p2 : points) {
                int d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                ans += cnt.getOrDefault(d, 0) * 2;
                cnt.merge(d, 1, Integer::sum);
            }
        }
        return ans;
    }
}
