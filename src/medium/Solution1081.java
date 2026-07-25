package medium;

// 1081. Smallest Subsequence of Distinct Characters

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1081 {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray())
            cnt.merge(c, 1, Integer::sum);
        StringBuilder sb = new StringBuilder();
        Set<Character> visited = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (visited.contains(c))
                continue;
            if (sb.isEmpty()) {
                sb.append(c);
            } else {
                while (!sb.isEmpty() && cnt.get(sb.charAt(sb.length() - 1)) > 0 && sb.charAt(sb.length() - 1) > c)
                    sb.deleteCharAt(sb.length() - 1);
            }
            visited.add(c);
        }

        return sb.toString();
    }
}
