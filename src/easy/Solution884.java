package easy;

// 884. Uncommon Words from Two Sentences

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");
        Map<String, Integer> cnt1 = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();
        for (String w : word1)
            cnt1.merge(w, 1, Integer::sum);
        for (String w : word2)
            cnt2.merge(w, 1, Integer::sum);
        List<String> ans = new ArrayList<>();
        for (String w : cnt1.keySet()) {
            if (cnt1.get(w) > 1 || cnt2.containsKey(w))
                continue;
            ans.add(w);
        }
        for (String w : cnt2.keySet()) {
            if (cnt2.get(w) > 1 || cnt1.containsKey(w))
                continue;
            ans.add(w);
        }
        return ans.toArray(new String[0]);
    }
}
