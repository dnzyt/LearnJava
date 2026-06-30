package easy;

// 2351. First Letter to Appear Twice

import java.util.HashSet;
import java.util.Set;

public class Solution2351 {
    public char repeatedCharacter(String s) {
        Set<Character> ss = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (ss.contains(ch))
                return ch;
            ss.add(ch);
        }
        return 'a';
    }
}
