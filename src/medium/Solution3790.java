package medium;

// 3790. Smallest All-Ones Multiple

import java.util.HashSet;
import java.util.Set;

public class Solution3790 {
    public int minAllOneMultiple(int k) {
        Set<Integer> seen = new HashSet<>();
        int x = 1;
        while (x != 0 && !seen.contains(x)) {
            seen.add(x);
            x = (x * 10 + 1) % k;
        }
        return x == 0 ? seen.size() + 1 : -1;
    }
}
