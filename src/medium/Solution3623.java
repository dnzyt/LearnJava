package medium;

// 3623. Count Number of Trapezoids I

import java.util.HashMap;
import java.util.Map;

public class Solution3623 {
    private static final int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            int v = map.getOrDefault(p[1], 0);
            map.put(p[1], v + 1);
        }

        long ans = 0;
        long s = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            long k = (long) entry.getValue() * (entry.getValue() - 1) / 2;
            ans += s * k;
            s += k;
        }
        return (int) (ans % MOD);
    }
}
