package medium;

// 3760. Maximum Substrings With Distinct Start

import java.util.HashSet;
import java.util.Set;

public class Solution3760 {
    public int maxDistinct(String s) {
        Set<Character> c = new HashSet<>();
        for (char ch : s.toCharArray())
            c.add(ch);
        return c.size();
    }
}
