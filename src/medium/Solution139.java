package medium;

// 139. Word Break

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution139 {
    private Map<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        if (memo.containsKey(s))
            return memo.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String sub = s.substring(word.length());
                if (wordBreak(sub, wordDict)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }
        memo.put(s, false);
        return false;
    }

}
