package medium;

// 3839. Number of Prefix Connected Groups

import java.util.HashMap;
import java.util.Map;

public class Solution3839 {
    public int prefixConnected(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            if (word.length() < k)
                continue;
            String sub = word.substring(0, k);
            cnt.merge(sub, 1, Integer::sum);
        }
        int ans = 0;
        for (String key : cnt.keySet())
            if (cnt.get(key) > 1)
                ans++;
        return ans;
    }
}
