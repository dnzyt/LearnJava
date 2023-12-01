package medium;

// 17. Letter Combinations of a Phone Number

import java.util.*;

public class Solution17 {

    Map<Character, String[]> mapping;
    public List<String> letterCombinations(String digits) {
        mapping = Map.of(
                '2', new String[] {"a", "b", "c"},
                '3', new String[] {"d", "e", "f"},
                '4', new String[] {"g", "h", "i"},
                '5', new String[] {"j", "k", "l"},
                '6', new String[] {"m", "n", "o"},
                '7', new String[] {"p", "q", "r", "s"},
                '8', new String[] {"t", "u", "v"},
                '9', new String[] {"w", "x", "y", "z"}
        );
        if (digits.isEmpty())
            return Collections.emptyList();
        return dfs(digits, 0);

    }

    private List<String> dfs(String digits, int start) {
        if (start == digits.length())
            return List.of("");
        List<String> res = new ArrayList<>();
        for (String c : mapping.get(digits.charAt(start))) {
            for (String df : dfs(digits, start + 1)) {
                res.add(c + df);
            }
        }
        return res;
    }

}
