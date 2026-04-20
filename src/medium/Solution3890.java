package medium;

import java.util.*;

public class Solution3890 {
    private static final int MX = 1_000_000_000;
    private static final List<Integer> goodIntegers = new ArrayList<>();
    private static boolean initialized = false;

    public Solution3890() {
        if (initialized)
            return;
        initialized = true;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a = 1; a * a * a <= MX / 2; a++) {
            for (int b = a; a * a * a + b * b * b <= MX; b++)
                cnt.merge(a * a * a + b * b * b, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() > 1)
                goodIntegers.add(e.getKey());
        }
        Collections.sort(goodIntegers);
    }

    public List<Integer> findGoodIntegers(int n) {
        int idx = Collections.binarySearch(goodIntegers, n + 1);
        if (idx < 0)
            idx = ~idx;
        return goodIntegers.subList(0, idx);
    }
}
