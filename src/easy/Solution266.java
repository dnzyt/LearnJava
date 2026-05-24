package easy;

// 266. Palindrome Permutation

import java.util.HashMap;
import java.util.Map;

public class Solution266 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char ch : s.toCharArray())
            cnt.merge(ch, 1, Integer::sum);
        boolean foundOne = false;
        for (int c : cnt.values()) {
            if (c % 2 == 1) {
                if (foundOne)
                    return false;
                foundOne = true;
            }
        }
        return true;
    }
}
