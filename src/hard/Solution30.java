package hard;

// 30. Substring with Concatenation of All Words

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words[0].length();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words)
            count.merge(word, 1, Integer::sum);
        List<Integer> ans = new ArrayList<>();
        for (int k = 0; k < m; k++) {
            int j = k;
            Map<String, Integer> cnt = new HashMap<>(count);
            for (int i = k + m; i <= n; i += m) {
                String sub = s.substring(i - m, i);
                cnt.merge(sub, -1, Integer::sum);
                if (cnt.get(sub) == 0)
                    cnt.remove(sub);
                if (i - j > words.length * m) {
                    sub = s.substring(j, j + m);
                    cnt.merge(sub, 1, Integer::sum);
                    if (cnt.get(sub) == 0)
                        cnt.remove(sub);
                    j += m;
                }
                if (i - j == words.length * m && cnt.size() == 0)
                    ans.add(j);
            }
        }
        return ans;
    }
}
