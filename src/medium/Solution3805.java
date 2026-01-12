package medium;

// 3805. Count Caesar Cipher Pairs

import java.util.HashMap;
import java.util.Map;

public class Solution3805 {
    public long countPairs(String[] words) {
        int n = words.length;
        Map<String, Long> cnt = new HashMap<>();
        long ans = 0;
        for (String word : words) {
            char[] wd = word.toCharArray();
            int m = word.length();
            StringBuilder sb = new StringBuilder();
            char base = wd[0];
            for (int i = 0; i < m; i++) {
                char t = (char) ((wd[i] - base + 26) % 26 + 'a');
                sb.append(t);
            }
            String key = sb.toString();
            ans += cnt.getOrDefault(key, 0L);
            cnt.merge(key, 1L, Long::sum);
        }
        return ans;
    }

}
