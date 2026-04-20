package medium;

// 3889. Mirror Frequency Distance

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3889 {
    public int mirrorFrequency(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        int ans = 0;
        Set<Character> visited = new HashSet<>();
        for (char c : cnt.keySet()) {
            if (visited.contains(c))
                continue;
            char m = '0';
            if (c >= '0' && c <= '9')
                m = (char) ('0' + (9 - (c - '0')));
            else
                m = (char) ('a' + (25 - (c - 'a')));
            ans += Math.abs(cnt.get(c) - cnt.getOrDefault(m, 0));
            visited.add(m);
            visited.add(c);
        }
        return ans;
    }
}
