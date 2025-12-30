package easy;

// 819. Most Common Word

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String b : banned)
            ban.add(b);
        char[] cs = paragraph.toCharArray();
        int i = 0;
        String ans = null;
        Map<String, Integer> cnt = new HashMap<>();
        while (i < cs.length) {
            if (!Character.isLetter(cs[i])) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < cs.length && Character.isLetter(cs[j]))
                j++;
            String sub = paragraph.substring(i, j).toLowerCase();
            i = j + 1;
            if (ban.contains(sub))
                continue;
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (ans == null || cnt.get(sub) > cnt.get(ans))
                ans = sub;
        }
        return ans;
    }
}
