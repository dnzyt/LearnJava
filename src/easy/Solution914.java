package easy;

// 914. X of a Kind in a Deck of Cards

import java.util.HashMap;
import java.util.Map;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : deck)
            cnt.merge(num, 1, Integer::sum);
        int g = -1;
        for (Integer k : cnt.keySet()) {
            if (g == -1)
                g = cnt.get(k);
            else
                g = gcd(g, cnt.get(k));
        }
        return g >= 2;
    }

    private int gcd(int x, int y) {
        while (y > 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }
}
