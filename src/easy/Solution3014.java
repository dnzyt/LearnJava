package easy;

// 3014. Minimum Number of Pushes to Type Word I

import java.util.HashSet;
import java.util.Set;

public class Solution3014 {
    public int minimumPushes(String word) {
        Set<Character> s = new HashSet<>();
        for (char c : word.toCharArray())
            s.add(c);
        int n = s.size() / 8;
        int x = s.size() % 8;
        return (1 + n) * n / 2 * 8 + (n + 1) * x;
    }
}
