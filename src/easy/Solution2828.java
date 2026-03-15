package easy;

// 2828. Check if a String Is an Acronym of Words

import java.util.List;

public class Solution2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i))
                return false;
        }
        return true;
    }
}
