package easy;

// 3856. Trim Trailing Vowels

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3856 {
    public String trimTrailingVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int i = s.length();
        for (int j = s.length() - 1; j >= 0; j--) {
            if (vowels.contains(s.charAt(j)))
                i--;
            else
                break;
        }
        return s.substring(0, i);
    }
}
