package hard;

// 3378. Count Connected Components in LCM Graph

import util.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution3378 {
    public int countComponents(int[] nums, int threshold) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, n).forEach(i -> map.put(nums[i], i));

        UnionFind uf = new UnionFind(n);
        for (int g = 1; g <= threshold; g++) {
            int minX = -1;
            for (int x = g; x * g <= threshold; x += g) {
                if (map.containsKey(x)) {
                    minX = x;
                    break;
                }
            }
            if (minX == -1) continue;
            int upper = (int) ((long) g * threshold / minX);
            for (int y = minX + g; y <= upper; y += g) {
                if (map.containsKey(y))
                    uf.merge(map.get(minX), map.get(y));
            }
        }
        return uf.count;
    }
}
