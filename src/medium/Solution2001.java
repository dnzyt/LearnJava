package medium;

// 2001. Number of Pairs of Interchangeable Rectangles

import java.util.HashMap;
import java.util.Map;

public class Solution2001 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Long, Long> map = new HashMap<>();
        long ans = 0;
        for (int[] r : rectangles) {
            int d = gcd(r[0], r[1]);
            long key = ((long) (r[0] / d) << 32) | (long) (r[1] / d);
            long cnt = map.getOrDefault(key, 0L);
            ans += cnt;
            map.put(key, cnt + 1);
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}
