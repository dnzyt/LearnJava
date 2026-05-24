package medium;

// 288. Unique Word Abbreviation

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution288 {
    class ValidWordAbbr {
        Map<String, Set<String>> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String s : dictionary) {
                if (s.length() == 2)
                    map.computeIfAbsent(s, k -> new HashSet<>()).add(s);
                else {
                    String abv = "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
                    map.computeIfAbsent(abv, k -> new HashSet<>()).add(s);
                }
            }
        }

        public boolean isUnique(String word) {
            String abv = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
            return map.getOrDefault(abv, new HashSet<>()).contains(word);
        }
    }
}
