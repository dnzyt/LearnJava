package medium;

// 2662. Minimum Cost of a Path With Special Roads

import java.util.*;

public class Solution2662 {

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        Map<Long, Integer> dist = new HashMap<>();
        long t = (long) target[0] << 32 | target[1];
        dist.put(t, Integer.MAX_VALUE / 2);
        dist.put((long) start[0] << 32 | start[1], 0);
        Set<Long> visited = new HashSet<>();
        for (; ; ) {
            long x = -1L;
            for (long k : dist.keySet()) {
                if (!visited.contains(k) && (x == -1L || dist.get(k) < dist.get(x))) {
                    x = k;
                }
            }
            visited.add(x);
            if (x == t)
                return dist.get(x);
            int a = (int) (x >> 32), b = (int) (x & Integer.MAX_VALUE);
            dist.merge(t, dist.get(x) + target[0] - a + target[1] - b, Math::min);
            for (int[] r : specialRoads) {
                int d = dist.get(x) + Math.min(Math.abs(r[0] - a) + Math.abs(r[1] - b) + r[4], Math.abs(a - r[2]) + Math.abs(b - r[3]));
                long w = (long) r[2] << 32 | r[3];
                if (d < dist.getOrDefault(w, Integer.MAX_VALUE))
                    dist.put(w, d);
            }
        }

    }
}
