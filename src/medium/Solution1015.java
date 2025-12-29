package medium;

// 1015. Smallest Integer Divisible by K

import java.util.HashSet;
import java.util.Set;

public class Solution1015 {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> seen = new HashSet<>();
        int x = 1 % k;
        while (x != 0 && !seen.contains(x)) {
            seen.add(x);
            x = (x * 10 + 1) % k;
        }
        return x == 0 ? seen.size() + 1 : -1;
    }
}
